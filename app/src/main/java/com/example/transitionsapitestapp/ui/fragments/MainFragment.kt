package com.example.transitionsapitestapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.transitionsapitestapp.R

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var editText: EditText
    private lateinit var button : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.main_fragment_layout, container, false)
        editText = view.findViewById(R.id.edit_text_main)
        button = view.findViewById(R.id.button_transition)
        button.setOnClickListener(this)
        return view
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