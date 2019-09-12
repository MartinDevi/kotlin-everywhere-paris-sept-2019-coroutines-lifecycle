package com.example.mdevillers.coroutineslifecycle.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.mdevillers.coroutineslifecycle.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class FragmentExample: Fragment() {

    private val fragmentExampleActivity
        get() = activity as FragmentExampleActivity?

    init {
        lifecycleScope.launch {
            for (i in 0..Long.MAX_VALUE) {
                delay(1000)
                fragmentExampleActivity?.counter?.text = i.toString()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewLifecycleOwner.lifecycleScope.launch {
            for (i in 0..Long.MAX_VALUE) {
                delay(1000)
                fragmentExampleActivity?.counterForView?.text = i.toString()
            }
        }
        return inflater.inflate(R.layout.fragment_example, container, false)
    }
}