package com.example.educenterroommvvm.vm

import androidx.lifecycle.LiveData
import com.example.educenterroommvvm.data.CourseData

interface CourseViewModel {

    val courseListLiveData: LiveData<List<CourseData>>
    val openAddCourseLiveData: LiveData<Unit>
    val openEditCourseLiveData: LiveData<Int>
    val openGroupScreenLiveData: LiveData<Int>

    fun insertCourse(courseData: CourseData)

    fun getAllCourses(): LiveData<List<CourseData>>

    fun getGroupsCount(courseId: Int): LiveData<Int>

    fun openAddCourseScreen()

    fun openGroupsScreen(id: Int)

    fun openEditCourseScreen(id: Int)


}