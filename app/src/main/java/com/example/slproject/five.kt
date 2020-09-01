package com.example.slproject

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
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
        requestBooks(userId)
    }
    fun notification(book: UserBook){
        val notifyID = 1
        val CHANNEL_ID = "my_channel_01" // The id of the channel.


        val importance = NotificationManager.IMPORTANCE_HIGH
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(CHANNEL_ID, "task", importance)

// Create a notification and set the notification channel.
            val notification: Notification = Notification.Builder(this, CHANNEL_ID)
                .setContentTitle("Smart Lib")
                .setContentText("Просрочена книга ${book.getName()}")
                .setSmallIcon(R.drawable.gvhngjm)
                .build()
            val mNotificationManager = this.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.notify(0, notification)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                mNotificationManager.createNotificationChannel(mChannel)
            }
        }else{
            val notification: Notification = Notification.Builder(this)
                .setContentTitle("Title")
                .setContentText("Content")
                .setSmallIcon(R.drawable.gvhngjm)
                .build()
            val mNotificationManager = this.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            mNotificationManager.notify(0, notification)
        }
    }
    private fun requestBooks(userId: String){


        val jsonList = t.userBookList(userId)

        val gson = Gson()
        val arrayBookType = object : TypeToken<ArrayList<UserBook>>() {}.type

        var books: ArrayList<UserBook> = gson.fromJson(JsonParser().parse(jsonList).getAsJsonObject().get("user_list"), arrayBookType)
        books.forEach{
            if(it.getNotification() == 1){
                notification(it)
            }
        }

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
