package com.example.slproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class five : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)
    }
    fun mybook (view: View){
        val randomIntent = Intent( this, MyBookScreen::class.java)
        startActivity(randomIntent)
    }
}