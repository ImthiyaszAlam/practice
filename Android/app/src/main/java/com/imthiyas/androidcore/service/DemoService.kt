package com.imthiyas.androidcore.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class DemoService : Service() {

    val TAG = "DemoService"

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        Log.d(TAG, "Service Started")
        stopSelf(startId)
        return START_NOT_STICKY


    }

    override fun onDestroy() {

        Log.d(TAG, "Service Destroyed")
        super.onDestroy()
    }


}