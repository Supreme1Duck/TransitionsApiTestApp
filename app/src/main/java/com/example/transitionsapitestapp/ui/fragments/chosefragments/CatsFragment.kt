package com.example.transitionsapitestapp.ui.fragments.chosefragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.transitionsapitestapp.databinding.FragmentCatsLayoutBinding
import dagger.android.support.DaggerFragment

class CatsFragment : DaggerFragment() {

    private lateinit var viewBinding : FragmentCatsLayoutBinding
    private lateinit var imageView: ImageView
    private lateinit var recyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentCatsLayoutBinding.inflate(inflater)
        with(viewBinding){
            imageView = catsImageView
            recyclerView = catsRecyclerView
        }
        return viewBinding.root
    }
}