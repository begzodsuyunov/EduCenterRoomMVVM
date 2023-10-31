package com.example.educenterroommvvm.repository

import androidx.lifecycle.LiveData
import com.example.educenterroommvvm.data.GroupData

interface GroupRepository {

    fun insertGroup(groupData: GroupData)

    fun updateGroup(groupData: GroupData)

    fun deleteGroup(groupData: GroupData)

    fun getAllGroups(id:Int): LiveData<List<GroupData>>

}