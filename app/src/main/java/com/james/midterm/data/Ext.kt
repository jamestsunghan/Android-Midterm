package com.james.midterm.data

import com.google.firebase.Timestamp

fun Author.toHashMap(): HashMap<String, String>{
    return hashMapOf(
        "name" to name,
        "id" to id,
        "email" to email
    )
}

fun Post.toHashMap(): HashMap<String,Any>{
    return hashMapOf(
        "author" to (author as Author).toHashMap(),
        "content" to content,
        "create_time" to create_time as Timestamp,
        "id" to id,
        "tag" to tag,
        "title" to title
    )
}