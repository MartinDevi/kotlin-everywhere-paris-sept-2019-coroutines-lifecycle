package com.example.mdevillers.coroutineslifecycle

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.lifecycle.ProcessLifecycleOwner
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.ticker
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()

        val processLifecycleOwner = ProcessLifecycleOwner.get()
        val lifecycleScope = processLifecycleOwner.lifecycleScope
        lifecycleScope.launch {
            try {
                delay(Long.MAX_VALUE)
            } catch (e: CancellationException) {
                e.printStackTrace()
                throw e
            }
        }

        lifecycleScope.launchWhenCreated {
            startNotificationTimer(NOTIFICATION_ID_CREATED, "Created")
        }
        lifecycleScope.launchWhenStarted {
            startNotificationTimer(NOTIFICATION_ID_STARTED, "Started")
        }
        lifecycleScope.launchWhenResumed {
            startNotificationTimer(NOTIFICATION_ID_RESUMED, "Resumed")
        }
    }

    private suspend fun startNotificationTimer(id: Int, title: String) {
        try {
            for (i in 0..Long.MAX_VALUE) {
                delay(1000)
                showNotification(id, title, "ACTIVE $i")
            }
        } catch (e: CancellationException) {
            showNotification(id, title, "CANCELLED")
            throw e
        }
    }

    private fun createNotificationChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "App Process Lifecycle",
            NotificationManager.IMPORTANCE_DEFAULT
        )
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    private fun showNotification(id: Int, title: String, text: String) {
        showNotification(id, createNotification(title, text))
    }

    private fun showNotification(id: Int, notification: Notification) {
        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(id, notification)
    }

    private fun createNotification(title: String, text: String): Notification =
        NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(title)
            .setContentText(text)
            .setOnlyAlertOnce(true)
            .build()

    companion object {
        const val CHANNEL_ID = "process_lifecycle"
        const val NOTIFICATION_ID_CREATED = 1
        const val NOTIFICATION_ID_STARTED = 2
        const val NOTIFICATION_ID_RESUMED = 3
    }
}