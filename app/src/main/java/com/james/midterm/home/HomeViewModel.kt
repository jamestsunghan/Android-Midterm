package com.james.midterm.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.james.midterm.CallBack
import com.james.midterm.DataSource
import com.james.midterm.data.Post

class HomeViewModel : ViewModel() {
    private val _posts = MutableLiveData<List<Post>>()
    val posts : LiveData<List<Post>> get() = _posts

    init{
        DataSource.getPosts(object :
            CallBack {
            override fun onCallback(posts: List<Post>) {
                _posts.value = posts
            }
        })
    }

}
