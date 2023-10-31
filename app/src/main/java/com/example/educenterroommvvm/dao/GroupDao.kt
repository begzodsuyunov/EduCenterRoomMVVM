package com.example.educenterroommvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.educenterroommvvm.data.GroupData

@Dao
interface GroupDao : BaseDao<GroupData>{

    @Query("SELECT * FROM `group` WHERE course_id=:id")
    fun getGroups(id: Int): LiveData<List<GroupData>>
}