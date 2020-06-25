package com.james.midterm.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.james.midterm.data.CallBack
import com.james.midterm.data.DataSource
import com.james.midterm.data.Post

class HomeViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts : LiveData<List<Post>> get() = _posts

    private val _navigateToPublish = MutableLiveData<Boolean>(false)
    val navigateToPublish : LiveData<Boolean> get() = _navigateToPublish

    init{
        DataSource.getPosts(object :
            CallBack {
            override fun onCallback(posts: List<Post>) {
                _posts.value = posts
            }

            override fun onCallBackBoolean(isPosted: Boolean) {
            }
        })
    }

    fun publish(){
        _navigateToPublish.value = true
    }

    fun navigateComplete(){
        _navigateToPublish.value = false
    }

}
