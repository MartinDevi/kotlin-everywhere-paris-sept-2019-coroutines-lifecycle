package com.example.mdevillers.coroutineslifecycle

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.mdevillers.coroutineslifecycle.launchwhenresumed.ResumedActivity
import com.example.mdevillers.coroutineslifecycle.viewmodel.ViewModelExampleActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.button_view_model).setOnClickListener {
            startActivity(Intent(this, ViewModelExampleActivity::class.java))
        }
        findViewById<View>(R.id.button_fragment).setOnClickListener {
            startActivity(Intent(this, FragmentActivity::class.java))
        }
        findViewById<View>(R.id.button_launch_when_resumed).setOnClickListener {
            startActivity(Intent(this, ResumedActivity::class.java))
        }
    }
}
