package com.example.transitionsapitestapp.ui.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.transitionsapitestapp.R

class SecondFragment : Fragment() {

    private lateinit var editText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment_layout, container, false)
        editText = view.findViewById(R.id.edit_text_second_fragment)
        val args : SecondFragmentArgs by navArgs()
        editText.setText(args.hello)
        getAnimation()
        return view
    }

    private fun getAnimation(){
        val animation = TransitionInflater.from(requireContext())
            .inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }
}