package com.example.mdevillers.coroutineslifecycle.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async

class MainViewModel: ViewModel() {

    val result  = viewModelScope.async { "" }
}