package com.i.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * from item_table")
    fun getItems(): LiveData<List<Item>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(item: Item)
    @Query("DELETE FROM item_table")
    fun deleteAll()
}