package com.example.slproject

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class serveractivity {
    private val client = HttpClient()

    private suspend fun userInfoGetBody(userId: String): String{
        try{
            var query = "https://ms3.newtonbox.ru/user/" + userId
            val res = client.get<String>(query)
            Log.i(query + " Simple case ", res)
            return res
        }
        catch (th : Throwable) {
            return "ОШИБКА"
        }
    }

    fun userInfoGet(userId: String): String{
        return runBlocking { userInfoGetBody(userId) }
    }
    private suspend fun userBookListBody(userId: String): String{
        try{
            var query = "https://ms3.newtonbox.ru/user_books/" + userId
            val res = client.get<String>(query)
            Log.i(query + " Simple case ", res)
            return res
        }
        catch (th : Throwable) {
            return "ОШИБКА"
        }
    }

    fun userBookList(userId: String): String{
        return runBlocking { userBookListBody(userId) }
    }
}