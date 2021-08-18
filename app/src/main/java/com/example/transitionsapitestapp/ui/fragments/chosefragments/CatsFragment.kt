package com.example.transitionsapitestapp.ui.fragments.chosefragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Fade
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity
import com.example.transitionsapitestapp.databinding.FragmentCatsLayoutBinding
import com.example.transitionsapitestapp.di.viewmodel_factory.ViewModelFactory
import com.example.transitionsapitestapp.ui.fragments.chosefragments.viewmodel.CatsFragmentViewModel
import com.example.transitionsapitestapp.utils.CatsFragmentAdapter
import com.example.transitionsapitestapp.utils.CatsTransition
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class CatsFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var viewBinding: FragmentCatsLayoutBinding
    private lateinit var imageView: ImageView
    private lateinit var recyclerView: RecyclerView
    private var catsList: CatsEntity = CatsEntity()
    private lateinit var viewModel: CatsFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[CatsFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentCatsLayoutBinding.inflate(inflater)
        with(viewBinding) {
            imageView = catsImageView
            recyclerView = catsRecyclerView
        }
        postponeEnterTransition()
        getAnimation()
        val adapter = initializeAdapter()
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        viewModel.getData(20)
        return viewBinding.root
    }

    private fun getAnimation() {
        loadAnimationDrawable()
        sharedElementEnterTransition = CatsTransition()
        enterTransition = Fade()
    }

    private fun initializeAdapter(): CatsFragmentAdapter {
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = CatsFragmentAdapter(catsList)
        return recyclerView.adapter as CatsFragmentAdapter
    }

    private fun loadAnimationDrawable() {
        imageView.transitionName = "Cats"
        val args: CatsFragmentArgs by navArgs()
        Glide.with(this)
            .load(args.image)
            .fitCenter()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.d("Logging exception", "Image not loaded")
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageView.setImageDrawable(resource)
                    startPostponedEnterTransition()
                    Log.d("Logging success", "Image Cats loaded.")
                    return false
                }

            }).submit()
        val density = this.resources.displayMetrics.density
        imageView.layoutParams = ViewGroup.LayoutParams((density * 35).toInt(), (density * 35).toInt())
    }
}