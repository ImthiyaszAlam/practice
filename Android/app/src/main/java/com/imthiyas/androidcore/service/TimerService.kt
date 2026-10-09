package com.imthiyas.androidcore.service

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.SystemClock
import android.util.Log
import java.util.Timer

class TimerService : Service() {

    private val tag = "TimerService"


    private val binder = LocalBinder()
    private var startTime = 0
    private var accumulatedTime = 0L
    private var isRunning = false


    inner class LocalBinder : Binder() {
        fun getService(): TimerService = this@TimerService

    }


    fun startTimer() {
        if (!isRunning) {
            startTime = SystemClock.elapsedRealtime().toInt()
            isRunning = true
        }
    }
    fun getElapsedSeconds(): Long {
        val elapsed = if (isRunning) {
            accumulatedTime +
                    (SystemClock.elapsedRealtime() - startTime)
        } else {
            accumulatedTime
        }

        return elapsed / 1000
    }

    fun stopTimer() {
        if (isRunning) {
            accumulatedTime +=
                SystemClock.elapsedRealtime() - startTime

            isRunning = false
            Log.d(tag, "Timer stopped")
        }
    }


    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }


    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return binder
    }
}