package com.example.educenterroommvvm.vm.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.educenterroommvvm.vm.SplashViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModelImpl : SplashViewModel, ViewModel() {

    override val openCourseScreen = MutableLiveData<Unit>()

    init {

        viewModelScope.launch {
            delay(1500)
            openCourseScreen.value = Unit
        }
    }
}