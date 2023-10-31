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
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.educenterroommvvm.R
import com.example.educenterroommvvm.vm.impl.EditCourseViewModelImpl

class EditCourseFragment : Fragment(R.layout.fragment_edit_course) {

    private lateinit var etName: EditText
    private lateinit var confirm: Button
    private lateinit var btnBack: ImageButton

    private val viewModel: EditCourseViewModelImpl by viewModels()

    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.backLiveData.observe(this){
            navController.navigateUp()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.et_edit_course)
        confirm = view.findViewById(R.id.btn_edit_courseS)
        btnBack = view.findViewById(R.id.btn_back_edit_course)

        val id = requireArguments().getInt("ID", id)

        confirm.setOnClickListener {
            viewModel.saveCourse(id, etName.text.toString())
            viewModel.back()
        }

        btnBack.setOnClickListener {
            viewModel.back()
        }


    }

}