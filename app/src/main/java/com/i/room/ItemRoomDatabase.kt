package com.i.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Item::class), version = 1, exportSchema = false)
abstract class ItemRoomDatabase: RoomDatabase() {
    abstract fun itemDao(): ItemDao
    companion object{
        @Volatile
        private var INSTANCE: ItemRoomDatabase? = null
        fun getDatabase(context: Context): ItemRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}