package com.example.mdevillers.coroutineslifecycle

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycleScope.launch {
            try {
                delay(Long.MAX_VALUE)
            } catch (e: CancellationException) {
                e.printStackTrace()
                throw e
            }
        }
    }
}