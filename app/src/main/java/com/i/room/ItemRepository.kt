package com.i.room

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {

    val allItems: LiveData<List<Item>> = itemDao.getItems()
    suspend fun insert(item: Item){
        itemDao.insert(item)
    }
}