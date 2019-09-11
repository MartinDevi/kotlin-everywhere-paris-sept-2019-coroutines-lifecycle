package com.example.mdevillers.coroutineslifecycle.fragment

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.async

class MainFragment: Fragment() {

    // We don't have a `asyncWhenCreated`, should we maybe so that this isn't started immediately?
    val result  = lifecycleScope.async { "" }
}