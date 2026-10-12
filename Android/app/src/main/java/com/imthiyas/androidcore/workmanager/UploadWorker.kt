package com.imthiyas.androidcore.workmanager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlinx.coroutines.delay


class UploadWorker(
    context: Context,
    params: WorkerParameters
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            Log.d("UploadWorker", "Upload started")

            // Simulate background work
            delay(3000)

            Log.d("UploadWorker", "Upload completed")

            Result.success()

        } catch (e: Exception) {
            Result.retry()
        }
    }
}