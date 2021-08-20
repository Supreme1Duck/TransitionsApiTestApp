package com.example.transitionsapitestapp.ui.fragments.chosefragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.transitionsapitestapp.data.fragment.news.basicnews.Article
import com.example.transitionsapitestapp.data.fragment.news.basicnews.News
import com.example.transitionsapitestapp.databinding.NewsFragmentBinding
import com.example.transitionsapitestapp.di.viewmodel_factory.ViewModelFactory
import com.example.transitionsapitestapp.ui.fragments.chosefragments.viewmodel.NewsFragmentViewModel
import com.example.transitionsapitestapp.utils.NewsFragmentAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import java.time.Duration
import javax.inject.Inject

class NewsFragment : DaggerFragment(), NewsFragmentAdapter.Listener {

    private lateinit var binding: NewsFragmentBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var button: Button
    private lateinit var editText: EditText
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
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
            button = btnSearch
            editText = etQuery
            swipeRefreshLayout = swipeRefresh
        }
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
        view?.let { Snackbar.make(it, "Clicked !", Snackbar.LENGTH_LONG) }
    }


    private fun getAnimation() {
        val animation = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

}