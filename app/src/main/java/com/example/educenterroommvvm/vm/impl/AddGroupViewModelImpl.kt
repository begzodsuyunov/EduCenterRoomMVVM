package com.example.educenterroommvvm.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educenterroommvvm.data.GroupData
import com.example.educenterroommvvm.repository.EduRepository
import com.example.educenterroommvvm.repository.GroupRepository
import com.example.educenterroommvvm.vm.AddGroupViewModel

class AddGroupViewModelImpl : AddGroupViewModel, ViewModel() {

    val repository: GroupRepository = EduRepository()


    override val confirmGroupLiveData = MutableLiveData<Unit>()
    override val backLiveData = MutableLiveData<Unit>()

    override fun confirmGroupLiveData() {
        confirmGroupLiveData.value = Unit
    }

    override fun saveGroup(name: String, mentor: String, courseId: Int) {
        repository.insertGroup(GroupData(0, name, mentor, courseId))
    }

    override fun back() {
        backLiveData.value = Unit
    }
}