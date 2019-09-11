package com.example.mdevillers.coroutineslifecycle.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

class ViewModelExample: ViewModel() {

    val resultAsync  = viewModelScope.async {
        delay(10000)
        "Sucess!"
    }
}