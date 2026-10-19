package com.imthiyas.androidcore.thread

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ThreadPracticeScreen() {

    var result by remember {
        mutableStateOf("Ready")
    }

    val scope = rememberCoroutineScope()


    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = "Threads")
        })
    }) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            Text(text = result)

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                scope.launch {
                    result = "Working"
                    val message = withContext(Dispatchers.IO) {
                        Thread.sleep(5000)
                        "Background work completed"
                    }
                    result = message

                }

            }) {
                Text("Run Background Work")
            }
        }

    }
}