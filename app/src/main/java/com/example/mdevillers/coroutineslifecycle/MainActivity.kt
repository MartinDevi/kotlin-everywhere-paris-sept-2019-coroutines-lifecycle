package com.example.mdevillers.coroutineslifecycle

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val image = findViewById<ImageView>(R.id.image)
        val imageResources = listOf(
            R.drawable.frame0,
            R.drawable.frame1,
            R.drawable.frame2,
            R.drawable.frame3,
            R.drawable.frame4,
            R.drawable.frame5
        )

        lifecycleScope.launchWhenResumed {
            var index = 0
            while (true) {
                image.setImageResource(imageResources[index])
                delay(150)
                index = (index + 1).rem(imageResources.size)
            }
        }
    }
}
