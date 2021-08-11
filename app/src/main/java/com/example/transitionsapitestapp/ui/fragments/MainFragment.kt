package com.example.transitionsapitestapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.transitionsapitestapp.databinding.MainFragmentLayoutBinding
import dagger.android.support.DaggerFragment

class MainFragment : DaggerFragment(), View.OnClickListener {

    private lateinit var viewBinding: MainFragmentLayoutBinding
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = MainFragmentLayoutBinding.inflate(inflater)
        val rootView = viewBinding.root
        with(viewBinding) {
            editText = editTextMain
            button = buttonTransition
            button.setOnClickListener(this@MainFragment)
            return rootView
        }
    }

    override fun onClick(p0: View?) {
        val extras = FragmentNavigatorExtras(
            editText to "hello_text"
        )
        val action = MainFragmentDirections.actionMainFragmentToSecondFragment()
        action.hello = editText.text.toString()
        findNavController().navigate(action, extras)
    }
}