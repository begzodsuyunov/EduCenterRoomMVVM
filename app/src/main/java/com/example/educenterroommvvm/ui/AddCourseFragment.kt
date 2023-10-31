package com.example.educenterroommvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.educenterroommvvm.R
import com.example.educenterroommvvm.vm.impl.AddCourseViewModelImpl

class AddCourseFragment : Fragment(R.layout.fragment_add_course) {

    private lateinit var etName: EditText
    private lateinit var btnConfirm: Button
    private lateinit var btnBack: ImageButton

    private val viewModelAddCourse: AddCourseViewModelImpl by viewModels()

    private val navController by lazy { findNavController() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelAddCourse.backLiveData.observe(this){
            navController.navigateUp()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.et_add_course)
        btnConfirm = view.findViewById(R.id.btn_confirm_course)
        btnBack = view.findViewById(R.id.btn_back_add_course)

        btnConfirm.setOnClickListener {
            viewModelAddCourse.saveCourse(etName.text.toString())
            viewModelAddCourse.back()
        }

        btnBack.setOnClickListener {
            viewModelAddCourse.back()
        }
    }
}