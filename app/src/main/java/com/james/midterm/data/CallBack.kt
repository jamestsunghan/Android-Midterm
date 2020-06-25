package com.james.midterm.data

interface CallBack{
    fun onCallback(posts: List<Post>)
    fun onCallBackBoolean(isPosted: Boolean)
}