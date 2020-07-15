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
    var sec = second()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)
    }
    fun mybook (view: View){
        val randomIntent = Intent( this, MyBookScreen::class.java)
        startActivity(randomIntent)
    }
    fun userInfoGet(view: View){
        // warning
        var userId : String = sec.a

        if( userId.isEmpty())
            userId = "5"

        val json = t.userInfoGet(userId)

        val gson = Gson()
        val UserType = object : TypeToken<UserInfo>() {}.type

        var userInfo: UserInfo = gson.fromJson(JsonParser().parse(json).getAsJsonObject().get("object"), UserType)

        UId.text = userInfo.getId().toString()
        Name.text = userInfo.getName()
        Who.text = userInfo.getPosition()
        Educ.text = userInfo.getEducation()
    }
    fun michaelTBookListActivity(view: View) {
        val intent = Intent(this, MyBookScreen::class.java)

        var userId : String = sec.a

        if( userId.isEmpty())
            userId = "5"

        intent.putExtra(MyBookScreen.USER_ID, userId)

        startActivity(intent)
    }
}
