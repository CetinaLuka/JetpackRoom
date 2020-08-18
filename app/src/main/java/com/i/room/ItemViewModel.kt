package com.i.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ItemRepository
    val allItems: LiveData<List<Item>>
    init {
        val itemsDao = ItemRoomDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemsDao)
        allItems = repository.allItems
    }

    fun insert(item: Item) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(item)
    }
}