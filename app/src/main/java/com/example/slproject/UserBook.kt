package com.example.slproject

import com.google.gson.annotations.SerializedName

class UserBook (
                @SerializedName("book__id") private var id : Int,
                @SerializedName("book__title") private var name: String,
                @SerializedName("book__author") private var author: String,
                @SerializedName("book__date_start") private var dateStart: String,
                @SerializedName("book__date_end") private var dateEnd: String,
                @SerializedName("book__notification") private var notification: Int
) {
    override fun toString(): String {
        return "Category [id: ${this.id}, author: ${this.author}, name: ${this.name}]"
    }

    fun getName() :String{
        return name
    }

    fun getAuthor() :String{
        return author
    }

    fun getDateStart() :String{
        return dateStart
    }

    fun getDateEnd() :String{
        return dateEnd
    }
    fun getNotification(): Int{
        return notification
    }
}