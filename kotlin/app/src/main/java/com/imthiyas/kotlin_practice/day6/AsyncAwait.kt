package com.imthiyas.kotlin_practice.day6

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun practiceAsyncAwait() {

    suspend fun getUserName(): String {
        return "Imthiyas Alam"
    }


    suspend fun getUserAge(): Int {
        return 25
    }

    suspend fun getUserMobile(): String {
        return "989789787878"
    }

    CoroutineScope(Dispatchers.Main).launch {


        val result = withContext(Dispatchers.IO) {


            val deferredName = async { getUserName() }
            val deferredAge = async { getUserAge() }
            val deferredMobile = async { getUserMobile() }

            Log.d("CoroutinePractice", " Deferred: $deferredName , $deferredAge , $deferredMobile")

            val name = deferredName.await()
            val age = deferredAge.await()
            val mobile = deferredMobile.await()



            Log.d("CoroutinePractice", "Result : $name , $age , $mobile")

            val allResult = awaitAll(deferredName, deferredAge, deferredMobile)

            Log.d("CoroutinePractice", "allResult- : $allResult")

        }


        Log.d("CoroutinePractice", "Result- : $result")

    }

}