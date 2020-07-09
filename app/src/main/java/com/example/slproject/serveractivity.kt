package com.example.slproject

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class serveractivity {
    private val client = HttpClient()

    fun test1() {
        GlobalScope.launch(Dispatchers.IO) {
            val data = client.get<String>("https://ms3.newtonbox.ru/user/1")
            Log.i("https://ms3.newtonbox.ru/user/1 Simple case ", data)
        }
    }
}