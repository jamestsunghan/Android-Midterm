package com.james.midterm.publish

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Timestamp.now
import com.james.midterm.MyApp
import com.james.midterm.R
import com.james.midterm.data.*

class PublishViewModel : ViewModel() {
    val title = MutableLiveData<String>()
    val tag = MutableLiveData<String>()
    val content = MutableLiveData<String>()
    private val authorDefault = Author(name = "James", id = "midterm", email = "james@midterm.com")

    private val _sendSuccess = MutableLiveData<Boolean>(false)

    val sendSuccess : LiveData<Boolean>
        get() = _sendSuccess


    private val _status = MutableLiveData<LoadStatus>()

    val status : LiveData<LoadStatus>
        get() = _status


    fun sendPost(){
        if(title.value ==null || tag.value == null || content.value == null){
            Toast.makeText(MyApp.appContext, MyApp.appContext.getText(R.string.not_complete), Toast.LENGTH_SHORT).show()
        }else{
            val post = Post(
                author = authorDefault,
                title = title.value as String,
                content = content.value as String,
                create_time = now(),
                tag = tag.value as String)

            DataSource.publishPost(post, object: CallBack {
                override fun onCallback(posts: List<Post>) {
                }

                override fun onCallBackBoolean(isPosted: Boolean) {
                    _sendSuccess.value = isPosted
                }

                override fun onCallbackStatus(status: LoadStatus) {
                    _status.value = status
                }
            })
        }
    }

    fun navigateComplete(){
        _sendSuccess.value = false
    }
}
