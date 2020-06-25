package com.james.midterm

import android.util.Log
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.james.midterm.data.Post

object DataSource{
    val db = Firebase.firestore
    val postCollection = db.collection("post")

    fun getPosts(callBack: CallBack){

        postCollection.get().addOnSuccessListener(object : OnSuccessListener<QuerySnapshot>{
            override fun onSuccess(p0: QuerySnapshot?) {
                var postListResult = mutableListOf<Post>()
                for(post in p0 as QuerySnapshot){
                        postListResult = postListResult.plus(post.toObject(Post::class.java)) as MutableList<Post>
                    }

                    callBack.onCallback(postListResult)
                }
        }).addOnFailureListener {
            Log.d("JJ","Error get posts $it")
        }
    }
}

interface CallBack{
    fun onCallback(posts: List<Post>)
}