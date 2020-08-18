package com.i.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(val item: String){
    @PrimaryKey(autoGenerate = true) var id: Int? = null
}