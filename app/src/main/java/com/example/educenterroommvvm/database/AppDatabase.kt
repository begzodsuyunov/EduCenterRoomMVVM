package com.example.educenterroommvvm.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.educenterroommvvm.dao.CourseDao
import com.example.educenterroommvvm.dao.GroupDao
import com.example.educenterroommvvm.data.CourseData
import com.example.educenterroommvvm.data.GroupData

@Database(entities = [CourseData::class, GroupData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun groupDao(): GroupDao

    abstract fun courseDao(): CourseDao

    companion object {
        private var instance : AppDatabase?= null
        fun init(context: Context){
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "appdatabase"
                )
                    .allowMainThreadQueries()
                    .build()
            }
        }
        fun getDatabase() = instance!!

    }

}