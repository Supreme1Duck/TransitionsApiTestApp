package com.example.transitionsapitestapp.ui.fragments.chosefragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.transitionsapitestapp.data.fragment.cats.entity.CatsEntity
import com.example.transitionsapitestapp.databinding.FragmentCatsLayoutBinding
import com.example.transitionsapitestapp.di.viewmodel_factory.ViewModelFactory
import com.example.transitionsapitestapp.ui.fragments.chosefragments.viewmodel.CatsFragmentViewModel
import com.example.transitionsapitestapp.utils.CatsFragmentAdapter
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
        val adapter = initializeAdapter()
        getAnimation()
        viewModel.liveData.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
        viewModel.getData(10)
        return viewBinding.root
    }

    private fun getAnimation() {
        loadAnimationDrawable()
        val animation = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.move)
        animation.duration = 1000
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    private fun initializeAdapter(): CatsFragmentAdapter {
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.adapter = CatsFragmentAdapter(catsList)
        return recyclerView.adapter as CatsFragmentAdapter
    }

    private fun loadAnimationDrawable() {
        imageView.transitionName = "Cats"
        val args: CatsFragmentArgs by navArgs()
        Glide.with(this).load(args.image).into(imageView)
    }
}