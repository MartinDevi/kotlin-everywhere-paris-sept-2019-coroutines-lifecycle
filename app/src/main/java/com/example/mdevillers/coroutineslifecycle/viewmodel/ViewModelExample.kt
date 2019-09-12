package com.example.mdevillers.coroutineslifecycle.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay

class ViewModelExample: ViewModel() {

    val resultChannel  = viewModelScope.produce {
        for (i in 0 until Long.MAX_VALUE) {
            send(i)
            delay(1000)
        }
    }
}