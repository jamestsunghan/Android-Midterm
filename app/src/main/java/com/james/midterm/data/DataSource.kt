package com.james.midterm.data


import android.util.Log
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object DataSource{

    private val postCollection = Firebase.firestore.collection("post")

    private var status = LoadStatus.INIT

    fun getPosts(callBack: CallBack){

        callBack.onCallbackStatus(LoadStatus.LOADING)

        postCollection.orderBy("create_time", Query.Direction.DESCENDING).get()
            .addOnSuccessListener { results ->
                var postListResult = mutableListOf<Post>()
                for(post in results){
                    postListResult = postListResult.plus(post.toObject(Post::class.java)) as MutableList<Post>
                }

                callBack.onCallbackStatus(LoadStatus.DONE)
                callBack.onCallback(postListResult)

            }.addOnFailureListener {
                callBack.onCallbackStatus(LoadStatus.FAIL)

            Log.d("JJ","Error get posts $it")
        }
    }

    fun publishPost(post: Post, callBack: CallBack){

        callBack.onCallbackStatus(LoadStatus.LOADING)

        postCollection.add(post.toHashMap()).addOnSuccessListener {

            postCollection.document(it.id).update("id",it.id)

            Log.d("JJ","success post $it")

            callBack.onCallbackStatus(LoadStatus.DONE)
            callBack.onCallBackBoolean(true)

        }.addOnFailureListener {

            callBack.onCallbackStatus(LoadStatus.FAIL)

            Log.d("JJ","Error send post $it")
        }
    }
}

