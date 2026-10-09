package com.imthiyas.androidcore

import android.content.Intent
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.imthiyas.androidcore.service.DemoService
import com.imthiyas.androidcore.service.UploadService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Composable
fun BackgroundWorkScreen() {

    var result by remember { mutableStateOf("Idle") }

    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(result)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                scope.launch {
                    result = "Working"
                    delay(300)
                    result = "Task Completed"
                }
            }
        ) {
            Text(text = "Start Background Work")
        }


        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val intent = Intent(context, DemoService::class.java)
                context.startService(intent)
            }
        ) {
            Text(text = "Start Service")
        }


        Spacer(modifier = Modifier.height(16.dp))


        Button(onClick = {
            val intent = Intent(context, UploadService::class.java)
            context.startService(intent)
        }) {
            Text(text = "Upload Service")
        }
    }

}