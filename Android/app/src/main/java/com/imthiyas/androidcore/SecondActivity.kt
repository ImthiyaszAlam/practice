package com.imthiyas.androidcore

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("LIFECYCLEMAIN", "onStart")
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