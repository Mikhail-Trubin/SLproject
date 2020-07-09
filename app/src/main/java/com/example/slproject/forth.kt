package com.example.slproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class forth : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forth)
    }
    fun ok3 (view: View){
        val randomIntent = Intent( this, five::class.java)
        startActivity(randomIntent)
    }
}