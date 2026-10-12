package com.imthiyas.androidcore

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.PixelCopy
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import com.imthiyas.androidcore.intents.ImplicitScreen
import com.imthiyas.androidcore.ui.theme.AndroidCoreTheme
import com.imthiyas.androidcore.workmanager.UploadWorker
import com.imthiyas.androidcore.workmanager.WorkManagerScreen

class MainActivity : ComponentActivity() {


    val TAG = "StartLogForMain"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            // BackgroundWorkScreen()
            // WorkManagerScreen()
            ImplicitScreen()

        }


    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", 1)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Composable
fun Home() {
    val TAG = "StartLogForMain"
    Log.d(TAG, "onCreate")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        val context = LocalContext.current

        Button(onClick = {
            val intent = Intent(context, SecondActivity::class.java)

        }) {
            Text(text = "Second")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidCoreTheme {
        Greeting("Android")
    }
}