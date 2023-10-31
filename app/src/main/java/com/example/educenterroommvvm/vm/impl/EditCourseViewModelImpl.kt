package com.example.educenterroommvvm.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educenterroommvvm.data.CourseData
import com.example.educenterroommvvm.repository.CourseRepository
import com.example.educenterroommvvm.repository.EduRepository
import com.example.educenterroommvvm.vm.EditCourseViewModel

class EditCourseViewModelImpl : EditCourseViewModel, ViewModel() {

    private val repository: CourseRepository = EduRepository()

    override val saveCourseLiveData = MutableLiveData<Unit>()

    override val backLiveData = MutableLiveData<Unit>()

    override fun confirmCourseLiveData() {
        TODO("Not yet implemented")
    }

    override fun saveCourse(id: Int, name: String) {
        repository.updateCourse(CourseData(id, name))
    }

    override fun back() {
        backLiveData.value = Unit
    }
}