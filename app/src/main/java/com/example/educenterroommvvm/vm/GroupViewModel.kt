package com.example.educenterroommvvm.vm

import androidx.lifecycle.LiveData
import com.example.educenterroommvvm.data.GroupData

interface GroupViewModel {

    val groupListLiveData: LiveData<List<GroupData>>

    val openAddGroupScreen: LiveData<Int>

    val backToCourseScreen: LiveData<Unit>

    val editGroupItem: LiveData<Int>

    val deleteGroupItem: LiveData<Unit>

    fun insertGroup(groupData: GroupData)

    fun updateGroup(groupData: GroupData)

    fun deleteGroup(groupData: GroupData)

    fun getGroups(id: Int)

    fun openAddGroupScreen(id: Int)

    fun back()

    fun openEditGroupScreen(id: Int)
}