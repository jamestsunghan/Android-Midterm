package com.james.midterm

import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Timestamp
import com.james.midterm.data.LoadStatus
import com.james.midterm.data.Post
import com.james.midterm.data.Tag
import com.james.midterm.home.HomeAdapter
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("time")
fun convertTimestampToDate(textView: TextView, time: Timestamp){
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = Date(time.seconds * 1000L)
    textView.text = formatter.format(date)
}

@BindingAdapter("posts")
fun bindPosts(view: RecyclerView, list: List<Post>?){
    val adapter = view.adapter as HomeAdapter
    adapter.submitList(list)
}

@BindingAdapter("tag")
fun bindTagWithBackground(view: TextView, tag: String){
    for(item in Tag.values()){
        if (item.value == tag){
            view.backgroundTintList = view.resources.getColorStateList(item.colorId, view.context.theme)
        }
    }
}

@BindingAdapter("list", "status")
fun bindListWithVisibility(view: TextView, posts: List<Post>?, status: LoadStatus){
    view.visibility = if(status == LoadStatus.LOADING){
        View.GONE
    }else if(posts == null || posts.isEmpty()){
        View.VISIBLE
    }else{
        View.GONE
    }
}