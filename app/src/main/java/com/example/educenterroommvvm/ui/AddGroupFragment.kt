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
import com.example.educenterroommvvm.vm.impl.AddGroupViewModelImpl


class AddGroupFragment : Fragment(R.layout.fragment_add_group) {
    private lateinit var etName: EditText
    private lateinit var etMentor: EditText
    private lateinit var btnSave: Button
    private lateinit var btnBack: ImageButton

    private val viewModel: AddGroupViewModelImpl by viewModels()

    private val navController: NavController by lazy { findNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.backLiveData.observe(this) {
            navController.navigateUp()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.et_add_group)
        etMentor = view.findViewById(R.id.et_add_mentor)
        btnSave = view.findViewById(R.id.btn_confirm_group)
        btnBack = view.findViewById(R.id.btn_back_add_group)

        btnSave.setOnClickListener {
            viewModel.saveGroup(
                etName.text.toString(),
                etMentor.text.toString(),
                requireArguments().getInt("ID")
            )
            viewModel.back()
        }


        btnBack.setOnClickListener {
            viewModel.back()
        }
    }
}