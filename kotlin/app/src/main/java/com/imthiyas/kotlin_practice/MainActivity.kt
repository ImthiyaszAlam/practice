package com.imthiyas.kotlin_practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialogDefaults.containerColor
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imthiyas.kotlin_practice.day5.extensions.addWelcome
import com.imthiyas.kotlin_practice.day5.extensions.calculateLength
import com.imthiyas.kotlin_practice.day5.practiceLateLazy
import com.imthiyas.kotlin_practice.day5.scopefunctions.practiceAlso
import com.imthiyas.kotlin_practice.day5.scopefunctions.practiceApply
import com.imthiyas.kotlin_practice.day5.scopefunctions.practiceLet
import com.imthiyas.kotlin_practice.day5.scopefunctions.practiceRun
import com.imthiyas.kotlin_practice.day5.scopefunctions.practiceWith
import com.imthiyas.kotlin_practice.day5.smartcast.practiceDestructuring
import com.imthiyas.kotlin_practice.day6.practiceAsyncAwait
import com.imthiyas.kotlin_practice.day6.practiceCoroutine
import com.imthiyas.kotlin_practice.day6.practiceSuspend
import com.imthiyas.kotlin_practice.ui.theme.Kotlin_practiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_practiceTheme {
                Practice()
            }
        }


        val name = "Imthiyas"

        Log.d("KotlinPractice", name.addWelcome())
        Log.d("KotlinPractice", "Length: ${name.calculateLength()}")

        practiceLet()
        practiceApply()
        practiceAlso()
        practiceRun()
        practiceWith()
        practiceDestructuring()
        practiceLateLazy()

        practiceSuspend()
        practiceCoroutine()
        practiceAsyncAwait()

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Practice() {

    val contents = listOf(
        "Basics",
        "Extension Function",
        "Scope Functions",
    )


    return Scaffold(topBar = {
        TopAppBar(
            title = {
                Text("Practice")

            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Blue,
                titleContentColor = Color.White
            )
        )
    }) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            contents.forEach {

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .border(
                            border = BorderStroke(1.dp, Color.Blue),
                            shape = RoundedCornerShape(4.dp)
                        )

                        .clip(shape = RoundedCornerShape(4.dp))
                ) {

                    Text(text = it, modifier = Modifier.padding(16.dp))
                }

            }

        }

    }
}





