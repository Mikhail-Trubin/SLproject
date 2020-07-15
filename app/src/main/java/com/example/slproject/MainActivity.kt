package com.example.slproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun reg(view: View){
        val randomIntent = Intent( this, second::class.java)
        startActivity(randomIntent)
    }
    fun enter (view: View){
        val randomIntent = Intent( this, forth::class.java)
        startActivity(randomIntent)
    }
}