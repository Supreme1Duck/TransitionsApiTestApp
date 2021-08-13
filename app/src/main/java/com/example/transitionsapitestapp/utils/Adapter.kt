package com.example.transitionsapitestapp.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.transitionsapitestapp.R

class Adapter(
    private var recyclerItems: List<RecyclerItem>,
    private val context: Context
) : RecyclerView.Adapter<Adapter.AdapterViewHolder>() {

    class AdapterViewHolder(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        var imageView : ImageView = itemView.findViewById(R.id.item_layout_image_view)
        var textView : TextView = itemView.findViewById(R.id.item_layout_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        Glide.with(context).load(recyclerItems[position].imageUrl).into(holder.imageView)
        holder.textView.text = recyclerItems[position].name
    }

    override fun getItemCount(): Int {
        return recyclerItems.size
    }

}