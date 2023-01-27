package com.ozancanguz.artbooktesting.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "arts")
data class Art(
    var name:String,
    var artistName:String,
    var artYear:Int,
    var imageUrl:String,

    @PrimaryKey(autoGenerate = true)
    var id:Int
)
