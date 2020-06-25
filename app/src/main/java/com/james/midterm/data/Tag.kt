package com.james.midterm.data

import com.james.midterm.R

enum class Tag(val value: String, val colorId: Int){
    MOVIE("Movie", R.color.blue_58b2dc),
    BEAUTY("Beauty", R.color.red_F17C67),
    GOSSIP("Gossip", R.color.yellow_e1a679),
    ELSE("",R.color.grey_dddddd)
}