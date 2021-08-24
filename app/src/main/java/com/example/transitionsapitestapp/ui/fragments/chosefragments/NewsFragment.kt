package com.example.transitionsapitestapp.ui.fragments.chosefragments

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.transition.TransitionInflater
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.transitionsapitestapp.data.fragment.news.basicnews.Article
import com.example.transitionsapitestapp.databinding.NewsFragmentBinding
import com.example.transitionsapitestapp.di.viewmodel_factory.ViewModelFactory
import com.example.transitionsapitestapp.ui.fragments.chosefragments.viewmodel.NewsFragmentViewModel
import com.example.transitionsapitestapp.utils.NewsFragmentAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NewsFragment : DaggerFragment(), NewsFragmentAdapter.Listener,
    SwipeRefreshLayout.OnRefreshListener, View.OnTouchListener {

    private lateinit var binding: NewsFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var editText: EditText
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var animationImage: ImageView
    private var newsList: ArrayList<Article> = ArrayList()

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var viewModel: NewsFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[NewsFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = NewsFragmentBinding.inflate(inflater)
        with(binding) {
            recyclerView = newsRecyclerView
            editText = etQuery
            swipeRefreshLayout = swipeRefresh
            animationImage = imageView
        }
        swipeRefreshLayout.setOnRefreshListener(this)
        editText.setOnTouchListener(this)
        getAnimation()
        recyclerView.adapter = NewsFragmentAdapter(this, newsList)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.liveData.observe(viewLifecycleOwner) {
            newsList = it.articles as ArrayList<Article>
            (recyclerView.adapter as NewsFragmentAdapter).setData(newsList)
        }
        return binding.root
    }

    override fun onItemClick() {
        Snackbar.make(binding.root, "Clicked", Snackbar.LENGTH_LONG).show()
    }

    override fun onRefresh() {
        Snackbar.make(binding.root, "Refreshed", Snackbar.LENGTH_LONG).show()
        swipeRefreshLayout.isRefreshing = false
    }

    private fun getAnimation() {
        val animation = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.move)
        loadAnimationImage()
        sharedElementEnterTransition = animation
    }

    private fun loadAnimationImage() {
        val args: CatsFragmentArgs by navArgs()
        Glide.with(this)
            .load(args.image)
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
                    startPostponedEnterTransition()
                    Log.d("Logging success", "Image Cats loaded.")
                    return false
                }

            }).into(animationImage)
    }

    override fun onTouch(view: View, p1: MotionEvent): Boolean {
        when (p1.action) {
            MotionEvent.ACTION_DOWN -> {
                view.performClick()
                Snackbar.make(binding.root, "Touching the EditText", Snackbar.LENGTH_LONG).show()
            }
        }
        return false
    }
}