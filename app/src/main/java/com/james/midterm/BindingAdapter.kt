package com.james.midterm

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.Timestamp
import com.james.midterm.data.Post
import com.james.midterm.home.HomeAdapter
import java.text.SimpleDateFormat
import java.util.*


@BindingAdapter("time")
fun convertTimestampToDate(textView: TextView, time: Timestamp){
    val formatter = SimpleDateFormat("yyyy-MM-dd HH-mm-ss")
    val date = Date(time.seconds * 1000L)
    textView.text = formatter.format(date)
}

@BindingAdapter("posts")
fun bindPosts(view: RecyclerView, list: List<Post>?){
    val adapter = HomeAdapter()
    view.adapter = adapter
    list?.let{
        adapter.submitList(list)
    }

}