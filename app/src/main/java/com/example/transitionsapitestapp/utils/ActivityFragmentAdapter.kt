package com.example.transitionsapitestapp.utils

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.transitionsapitestapp.R

class ActivityFragmentAdapter(
    private var recyclerItems: List<RecyclerItem>,
    private val listener: OnClickListener
) : RecyclerView.Adapter<ActivityFragmentAdapter.AdapterViewHolder>() {

    private lateinit var context: Context

    inner class AdapterViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.item_layout_image_view)
        var textView: TextView = itemView.findViewById(R.id.item_layout_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return AdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val imageView = holder.imageView
        val textView = holder.textView
        val url = recyclerItems[position].imageUrl
        Glide.with(context).load(url)
            .apply(
                RequestOptions().dontTransform()
            )
            .into(imageView)
        textView.text = recyclerItems[position].name
        imageView.setOnClickListener {
            listener.onItemClick(imageView, textView, url)
        }
    }

    override fun getItemCount(): Int {
        return recyclerItems.size
    }

    interface OnClickListener {
        fun onItemClick(imageView: ImageView, text: TextView, url: String)
    }
}