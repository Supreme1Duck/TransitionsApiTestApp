package com.example.transitionsapitestapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.transitionsapitestapp.databinding.MainFragmentLayoutBinding
import com.example.transitionsapitestapp.di.viewmodel_factory.ViewModelFactory
import com.example.transitionsapitestapp.ui.MainActivity
import com.example.transitionsapitestapp.ui.fragments.viewmodels.MainFragmentViewModel
import com.example.transitionsapitestapp.utils.CustomAlertDialog
import com.example.transitionsapitestapp.utils.Validation
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MainFragment : DaggerFragment(), View.OnClickListener {

    private lateinit var viewBinding: MainFragmentLayoutBinding
    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var cloudsTextView: TextView
    private lateinit var temperatureTextView: TextView
    private lateinit var tempFeelsLikeTextView: TextView
    private lateinit var windTextView: TextView
    private lateinit var pressureTextView: TextView
    private lateinit var transitionTextView: TextView
    private lateinit var validationText: TextView
    private lateinit var mainActivity : MainActivity

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var viewModel: MainFragmentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        viewModel = ViewModelProvider(this, factory)[MainFragmentViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = MainFragmentLayoutBinding.inflate(inflater)
        val rootView = viewBinding.root
        CustomAlertDialog(requireContext(), viewBinding.root).show()
        with(viewBinding) {
            editText = editTextMain
            button = buttonTransition
            cloudsTextView = clouds
            temperatureTextView = weather
            tempFeelsLikeTextView = weatherFeel
            windTextView = wind
            pressureTextView = pressure
            transitionTextView = heloTextTransition
            validationText = textValidation
            button.setOnClickListener(this@MainFragment)
            return rootView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveData.observe(viewLifecycleOwner) {
            cloudsTextView.text = it.weather[0].description
            temperatureTextView.text = it.main.temp.toString()
            tempFeelsLikeTextView.text = (it.main.temp - 2.5).toString()
            windTextView.text = it.wind.speed.toString() + "m/s"
            pressureTextView.text = it.main.pressure.toString() + "PA"
        }
        viewModel.getWeather("Minsk")
    }

    override fun onClick(p0: View?) {
        transitionTextView.text = editText.text
        if (Validation.validate(transitionTextView.text.toString())) {
            val extras = FragmentNavigatorExtras(
                transitionTextView to "hello_text"
            )
            val action = MainFragmentDirections.actionMainFragmentToSecondFragment()
            editText.text.toString().also { action.hello = it }
            findNavController().navigate(action, extras)
        }else{
            validationText.visibility = View.VISIBLE
        }
    }
}