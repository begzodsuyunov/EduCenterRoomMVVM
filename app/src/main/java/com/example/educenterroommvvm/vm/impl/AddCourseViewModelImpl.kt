package com.example.educenterroommvvm.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.educenterroommvvm.data.CourseData
import com.example.educenterroommvvm.repository.CourseRepository
import com.example.educenterroommvvm.repository.EduRepository
import com.example.educenterroommvvm.vm.AddCourseViewModel

class AddCourseViewModelImpl : AddCourseViewModel, ViewModel() {
    val repository: CourseRepository = EduRepository()

    override val confirmCourseLiveData = MutableLiveData<Unit>()

    override val backLiveData = MutableLiveData<Unit>()

    override fun confirmCourseLiveData() {
        confirmCourseLiveData.value = Unit
    }

    override fun saveCourse(name: String) {
        repository.insertCourse(CourseData(0, name))
    }

    override fun back() {
        backLiveData.value = Unit
    }
}