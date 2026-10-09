package com.imthiyas.androidcore.service

import android.app.Service
import android.content.Intent
import android.os.IBinder

class ForegroundTimerService : Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}