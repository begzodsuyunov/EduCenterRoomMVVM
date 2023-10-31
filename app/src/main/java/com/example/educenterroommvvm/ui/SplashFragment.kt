package com.example.educenterroommvvm.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.educenterroommvvm.R
import com.example.educenterroommvvm.vm.impl.SplashViewModelImpl


class SplashFragment : Fragment(R.layout.fragment_fplash) {
    private val viewModel: SplashViewModelImpl by viewModels()
    private val navController by lazy { findNavController() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.openCourseScreen.observe(viewLifecycleOwner) {
            navController.navigate(R.id.action_splashFragment_to_courseFragment)
        }
    }
}