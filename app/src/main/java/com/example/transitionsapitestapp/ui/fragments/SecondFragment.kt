package com.example.transitionsapitestapp.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.postDelayed
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.transitionsapitestapp.databinding.SecondFragmentLayoutBinding

class SecondFragment : Fragment() {

    private lateinit var nameTextView: TextView
    private lateinit var viewBinding: SecondFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = SecondFragmentLayoutBinding.inflate(inflater)
        val rootView = viewBinding.root
        with(viewBinding) {
            nameTextView = textViewName
        }
        val args: SecondFragmentArgs by navArgs()
        nameTextView.text = args.hello
        nameTextView.visibility = View.VISIBLE
        getAnimation()
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val action = SecondFragmentDirections.actionSecondFragmentToActivityFragment()
        nameTextView.text.toString().also { action.helloName = it }
        val extras = FragmentNavigatorExtras(
            nameTextView to "hello_name"
        )
        Handler().postDelayed(1000) {
            findNavController().navigate(action, extras)
        }
    }

    private fun getAnimation() {
        val animation = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.explode)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }
}