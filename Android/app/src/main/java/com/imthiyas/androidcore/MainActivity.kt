package com.imthiyas.androidcore

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.imthiyas.androidcore.ui.theme.AndroidCoreTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LIFECYCLEMAIN", "onCreate")
        enableEdgeToEdge()
        val count = savedInstanceState?.get("count") ?: 0
        Log.d("LIFECYCLEMAIN", "$count")


        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val context = LocalContext.current
                Text(text = "$count")
                Button(onClick = {
                    val intent = Intent(context, SecondActivity::class.java)
                    startActivity(intent)
                }) {
                    Text(text = "Second")
                }
            }

        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("count", 1)
        super.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLEMAIN", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLEMAIN", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLEMAIN", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLEMAIN", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLEMAIN", "onDestroy")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidCoreTheme {
        Greeting("Android")
    }
}