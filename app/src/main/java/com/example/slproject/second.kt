package com.example.slproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun ok (view: View) {
        val randomIntent = Intent( this, five::class.java)
        randomIntent.putExtra("secondUserId", userid.text)
        startActivity(randomIntent)
    }
}