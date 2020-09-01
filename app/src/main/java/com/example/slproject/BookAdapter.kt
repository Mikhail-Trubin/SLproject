package com.example.slproject

import android.content.Context
import android.graphics.Color
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter (var context: Context, var books: List<UserBook>): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var nameB: TextView
        var authorB: TextView
        var dateStartB: TextView
        var dateEndB: TextView
        init {
            this.nameB = itemView.findViewById(R.id.itemBookNameTextView) as TextView
            this.authorB = itemView.findViewById(R.id.itemBookAuthorTextView) as TextView
            this.dateStartB = itemView.findViewById(R.id.itemBookDateStartTextView) as TextView
            this.dateEndB = itemView.findViewById(R.id.itemBookDateEndTextView) as TextView
        }
        fun bind(book: UserBook){
            nameB.text = "Название: "+book.getName()
            authorB.text = "Автор: "+book.getAuthor()
            dateStartB.text = "Взял: "+book.getDateStart()
            dateEndB.text = "Сдать: "+book.getDateEnd()
            if (book.getNotification() == 1){
                itemView.setBackgroundColor(Color.RED)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.book, parent, false)
        return BookViewHolder(view)
    }

    override fun getItemCount(): Int {
      return  books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
       holder.bind(books[position])
    }

}