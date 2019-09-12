package com.example.mdevillers.coroutineslifecycle.fragment

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mdevillers.coroutineslifecycle.R

class FragmentExampleActivity : AppCompatActivity() {

    lateinit var counter: TextView
        private set
    lateinit var counterForView: TextView
        private set

    private val fragment by lazy {
        supportFragmentManager.findFragmentById(R.id.frame) ?: FragmentExample()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example)

        counter = findViewById(R.id.text_counter)
        counterForView = findViewById(R.id.text_view_counter)

        findViewById<View>(R.id.button_add_fragment).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame, fragment)
                .commit()
        }
        findViewById<View>(R.id.button_remove_fragment).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .remove(fragment)
                .commit()
        }
    }
}
