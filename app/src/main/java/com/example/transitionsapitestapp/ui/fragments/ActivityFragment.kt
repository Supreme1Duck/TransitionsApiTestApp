package com.example.transitionsapitestapp.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.transitionsapitestapp.databinding.FragmentActivityBinding
import com.example.transitionsapitestapp.utils.ActivityFragmentAdapter
import com.example.transitionsapitestapp.utils.Constants

class ActivityFragment : Fragment(), ActivityFragmentAdapter.OnClickListener {

    private lateinit var binding: FragmentActivityBinding
    private lateinit var nameText: TextView
    private lateinit var whatText: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActivityBinding.inflate(inflater)
        val rootView = binding.root
        val args: ActivityFragmentArgs by navArgs()
        with(binding) {
            nameText = nameTextView
            whatText = whatYouWant
        }
        getAnimation()
        nameText.text = args.helloName + ","
        Handler().postDelayed(700) {
            whatText.visibility = View.VISIBLE
        }
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerView.adapter = ActivityFragmentAdapter(Constants.recyclerItems, this)
        Handler().postDelayed(1500) {
            binding.recyclerView.visibility = View.VISIBLE
        }
        return rootView
    }

    private fun getAnimation() {
        val animation = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.explode)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

    override fun onItemClick(imageView: ImageView, text: TextView, url: String) {
        when (text.text) {
            // Cats
            Constants.recyclerItems[0].name -> {
                imageView.transitionName = "Cats"
                val extras = FragmentNavigatorExtras(
                    imageView to "Cats"
                )
                val action = ActivityFragmentDirections.actionActivityFragmentToCatsFragment()
                action.image = url
                findNavController().navigate(action, extras)
            }
            // Weather
            Constants.recyclerItems[1].name -> {

            }
            // News
            Constants.recyclerItems[2].name -> {

            }
            // Movies
            Constants.recyclerItems[3].name -> {

            }
        }
    }
}