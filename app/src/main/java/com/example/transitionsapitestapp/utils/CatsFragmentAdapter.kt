package com.example.transitionsapitestapp.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.transitionsapitestapp.R
import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity

class CatsFragmentAdapter(
    private var catsList: CatsEntity
) : RecyclerView.Adapter<CatsFragmentAdapter.CatsHolder>() {

    private lateinit var context: Context

    class CatsHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.cats_image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsHolder {
        context = parent.context
        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.cats_recycler_item, parent, false)
        return CatsHolder(itemView)
    }

    override fun onBindViewHolder(holder: CatsHolder, position: Int) {
        val imageUrl = catsList[position].url
        Glide.with(context).load(imageUrl).into(holder.imageView)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(it : CatsEntity){
        catsList = it
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = catsList.size
}