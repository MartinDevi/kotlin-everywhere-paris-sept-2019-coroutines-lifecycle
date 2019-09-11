package com.example.mdevillers.coroutineslifecycle.viewmodel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mdevillers.coroutineslifecycle.R
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelProvider = ViewModelProvider(this)
        val viewModel = viewModelProvider[MainViewModel::class.java]
        lifecycleScope.launch {
            viewModel.result.await()
        }
    }
}
