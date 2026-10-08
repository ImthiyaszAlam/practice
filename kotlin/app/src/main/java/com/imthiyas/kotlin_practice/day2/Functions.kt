package com.imthiyas.kotlin_practice.day2

import android.util.Log
import androidx.compose.runtime.Composable

fun practiceFunctions() {

    val TAG = "practiceFunctions"

    fun sayHello() {
        Log.d(TAG, "Hello Imthiyas")
    }

    fun sayHelloParam(name: String) {
        Log.d(TAG, "Hello $name")
    }

    fun addNumbers(a: Int, b: Int): Int {
        return a + b

    }

    val result = addNumbers(3, 4)

    Log.d(TAG, "Hello $result")

    fun multiply(a: Int, b: Int): Int {
        return a * b
    }

    val result0 = multiply(3, 4)
    Log.d(TAG, "Hello $result0")
}