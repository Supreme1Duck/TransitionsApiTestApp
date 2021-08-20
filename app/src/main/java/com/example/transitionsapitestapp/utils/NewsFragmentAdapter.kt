package com.example.transitionsapitestapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.transitionsapitestapp.R
import com.example.transitionsapitestapp.data.fragment.news.basicnews.Article

class NewsFragmentAdapter(
    private val listener: Listener,
    private var list: List<Article>
) : RecyclerView.Adapter<NewsFragmentAdapter.NewsViewHolder>() {

    private lateinit var context: Context

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.text_title)
        val source: TextView = itemView.findViewById(R.id.text_source)
        val publishedAt: TextView = itemView.findViewById(R.id.text_date)

        init {
            itemView.setOnClickListener {
                listener.onItemClick()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val imageUrl = list[position].urlToImage
        Glide.with(context).load(imageUrl).into(holder.imageView)
        holder.title.text = list[position].title
        holder.source.text = list[position].source.name
        holder.publishedAt.text = list[position].publishedAt
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listNews: ArrayList<Article>) {
        list = listNews
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = list.size

    interface Listener {
        fun onItemClick()
    }
}