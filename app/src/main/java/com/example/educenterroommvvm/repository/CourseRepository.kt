package com.example.educenterroommvvm.repository

import androidx.lifecycle.LiveData
import com.example.educenterroommvvm.data.CourseData

interface CourseRepository {
    fun insertCourse(courseData: CourseData)

    fun updateCourse(courseData: CourseData)

    fun getAllCourses(): LiveData<List<CourseData>>

    fun getGroupsCount(courseId: Int): LiveData<Int>
}