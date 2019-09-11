package com.example.mdevillers.coroutineslifecycle.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mdevillers.coroutineslifecycle.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (supportFragmentManager.findFragmentByTag(MainFragment::class.java.simpleName) == null) {
            supportFragmentManager.beginTransaction()
                .add(MainFragment::class.java, null, MainFragment::class.java.simpleName)
                .commit()
        }
    }
}
