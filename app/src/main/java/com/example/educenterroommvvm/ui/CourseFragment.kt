package com.example.educenterroommvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.educenterroommvvm.R
import com.example.educenterroommvvm.adapters.CourseAdapter
import com.example.educenterroommvvm.vm.impl.CourseViewModelImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CourseFragment : Fragment(R.layout.fragment_course) {

    private lateinit var container: RecyclerView
    private lateinit var btnAdd: FloatingActionButton
    private val viewModel: CourseViewModelImpl by viewModels()
    private val adapter: CourseAdapter by lazy { CourseAdapter() }
    private val navController by lazy { findNavController() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openAddCourseLiveData.observe(this) {
            navController.navigate(R.id.action_courseFragment_to_addCourseFragment)
        }

        viewModel.openEditCourseLiveData.observe(this) {
            navController.navigate(R.id.action_courseFragment_to_editCourseFragment, bundleOf(Pair("ID", it)))
        }

        viewModel.openGroupScreenLiveData.observe(this) {
            navController.navigate(
                R.id.action_courseFragment_to_groupFragment,
                bundleOf(Pair("CourseId", it))
            )
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd = view.findViewById(R.id.btn_add_course)
        container = view.findViewById(R.id.container_course)

        container.adapter = adapter

        viewModel.courseListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        btnAdd.setOnClickListener {
            viewModel.openAddCourseScreen()
        }

        adapter.setOnEditCourseListener {
            viewModel.openEditCourseScreen(it)
        }

        adapter.setOnAddGroupListener {
            viewModel.openGroupsScreen(it)
        }

    }



}