package com.example.transitionsapitestapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.transitionsapitestapp.databinding.MainFragmentLayoutBinding
import com.example.transitionsapitestapp.di.viewmodel_factory.ViewModelFactory
import com.example.transitionsapitestapp.ui.viewmodels.MainFragmentViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment(), View.OnClickListener {

    private lateinit var viewBinding: MainFragmentLayoutBinding
    private lateinit var editText: EditText
    private lateinit var button: Button

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, factory)[MainFragmentViewModel::class.java]
        Log.d("TAGGG", viewModel.useCase.toString())

    }

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
        editText.text.toString().also { action.hello = it }
        findNavController().navigate(action, extras)
    }
}