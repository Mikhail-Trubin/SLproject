package com.example.slproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_five.*


class five : AppCompatActivity() {
    var t = serveractivity()
    var userId = "1"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)
    }

    override fun onResume() {
        super.onResume()

        userId = getIntent().getExtras()!!.get("secondUserId").toString()

        val json = t.userInfoGet(userId)

        val gson = Gson()
        val UserType = object : TypeToken<UserInfo>() {}.type

        var userInfo: UserInfo = gson.fromJson(JsonParser().parse(json).getAsJsonObject().get("object"), UserType)

        UId.text = userInfo.getId().toString()
        Name.text = userInfo.getName()
        Who.text = userInfo.getPosition()
        Educ.text = userInfo.getEducation()
    }

    fun mybook (view: View){
        val randomIntent = Intent( this, MyBookScreen::class.java)
        startActivity(randomIntent)
    }

    fun michaelTBookListActivity(view: View) {
        val intent = Intent(this, MyBookScreen::class.java)

        intent.putExtra("fiveUserId", userId)

        startActivity(intent)
    }

    fun infodev (view: View){
        val randomIntent = Intent( this, infodev::class.java)
        startActivity(randomIntent)
    }
}
