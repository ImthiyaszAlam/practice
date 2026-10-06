package com.imthiyas.kotlin_practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.imthiyas.kotlin_practice.ui.theme.Kotlin_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_practiceTheme {

            }
        }

        val name: String = "Imthiyas Alam"
        val result = name.addWelcome()
        println(result)

        Log.d("Result", result)


        val length = "Android".calculateLength()
        Log.d("Length", "$length")


    }


}


fun String.addWelcome(): String {
    return "Welcome $this"
}

fun String.calculateLength(): Int {
    return this.length
}


