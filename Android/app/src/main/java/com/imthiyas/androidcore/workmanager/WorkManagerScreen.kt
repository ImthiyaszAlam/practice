package com.imthiyas.androidcore.workmanager

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.widget.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkManagerScreen() {

    val constraints = androidx.work.Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()

    val workRequest = OneTimeWorkRequestBuilder<UploadWorker>()
        .setConstraints(constraints)
        .build()

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Work Manager")
            })

        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {

            Button(onClick = {

                WorkManager.getInstance(context).enqueue(workRequest)
            }) {
                Text(text = "Start")
            }

        }

    }
}