package com.example.sample1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val inputStepCount = MutableLiveData<Int>()
}