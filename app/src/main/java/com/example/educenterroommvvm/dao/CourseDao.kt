package com.example.educenterroommvvm.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.educenterroommvvm.data.CourseData

@Dao
interface CourseDao : BaseDao<CourseData> {

    @Query("SELECT* FROM 'course'")
    fun getAllCourses(): LiveData<List<CourseData>>

    @Query("SELECT COUNT(id) FROM 'group' WHERE course_id=:courseId")
    fun getGroupsCount(courseId: Int): LiveData<Int>

}