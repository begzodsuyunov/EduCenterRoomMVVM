package com.example.educenterroommvvm.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.educenterroommvvm.R
import com.example.educenterroommvvm.adapters.GroupAdapter
import com.example.educenterroommvvm.vm.impl.GroupViewModelImpl
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GroupFragment : Fragment(R.layout.fragment_group) {
    private lateinit var container: RecyclerView
    private lateinit var addButton: FloatingActionButton
    private lateinit var btnBack: ImageButton

    private val adapter: GroupAdapter by lazy { GroupAdapter() }
    private val viewModel: GroupViewModelImpl by viewModels()
    private val navController: NavController by lazy { findNavController() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.openAddGroupScreen.observe(this) {
            navController.navigate(
                R.id.action_groupFragment_to_addGroupFragment,
                bundleOf(Pair("ID", it))
            )
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        container = view.findViewById(R.id.container_group)
        addButton = view.findViewById(R.id.btn_add_group)
        btnBack = view.findViewById(R.id.btn_back)

        container.adapter = adapter

        val courseId = requireArguments().getInt("CourseId")

        viewModel.getGroups(courseId)

        viewModel.groupListLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        addButton.setOnClickListener {
            viewModel.openAddGroupScreen(courseId)
        }

        adapter.setOnDeleteListener {
            viewModel.deleteGroup(it)
        }

        btnBack.setOnClickListener{
            navController.navigateUp()
        }
    }
}