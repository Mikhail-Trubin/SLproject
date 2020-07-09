package com.example.slproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class third : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
    }
    fun ok2 (view: View){
        val randomIntent = Intent( this, forth::class.java)
        startActivity(randomIntent)
    }
}