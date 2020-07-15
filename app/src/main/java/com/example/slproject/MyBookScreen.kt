package com.example.slproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken

class MyBookScreen : AppCompatActivity() {
    companion object {
        const val USER_ID = "5"
    }
    private var t = serveractivity()
    private lateinit var listView : ListView
    var sec = second()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_book_screen)
        val jsonList = t.userBookList(USER_ID)

        val gson = Gson()
        val arrayBookType = object : TypeToken<ArrayList<UserBook>>() {}.type

        var books: ArrayList<UserBook> = gson.fromJson(JsonParser().parse(jsonList).getAsJsonObject().get("user_list"), arrayBookType)
        // выведим в консоль список который мы получили
        books.forEachIndexed  { idx, dev -> println("> Item ${idx}:\n${dev}") }

        listView = findViewById<ListView>(R.id.michaelTBookList)

        listView.adapter = BookAdapter(this, books)
    }
}