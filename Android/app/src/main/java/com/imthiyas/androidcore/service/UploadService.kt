package com.imthiyas.androidcore.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class UploadService : Service() {


    private val tag = "UploadService"
    private val job = SupervisorJob()

    private val serviceScope = CoroutineScope(
        job + Dispatchers.IO
    )

    private var uploadJob: Job? = null


    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        uploadJob?.cancel()
        uploadJob = serviceScope.launch {
            for (record in 1..5) {
                if (!isActive) break
                Log.d(tag, "Uploading record $record")
                delay(300)
                Log.d(tag, "Record $record uploaded")

            }
            stopSelf()
        }
        return START_NOT_STICKY
    }

    override fun onRebind(intent: Intent?) {
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}