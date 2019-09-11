package com.example.mdevillers.coroutineslifecycle.viewmodel

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.mdevillers.coroutineslifecycle.R
import kotlinx.coroutines.launch

class ViewModelExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumed)

        val viewModelProvider = ViewModelProvider(this)
        val viewModel = viewModelProvider[ViewModelExample::class.java]
        lifecycleScope.launch {
            val result = viewModel.resultAsync.await()
            val textView = findViewById<TextView>(R.id.text)
            textView.text = result
        }
    }
}
