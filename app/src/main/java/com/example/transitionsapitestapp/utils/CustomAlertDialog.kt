package com.example.transitionsapitestapp.utils

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.widget.Button
import com.example.transitionsapitestapp.databinding.CustomAlertDialogBinding
import com.example.transitionsapitestapp.utils.Constants.loadingColors
import com.google.android.material.snackbar.Snackbar

class CustomAlertDialog(
    context: Context,
    val view: View
) : AlertDialog(context), View.OnClickListener {

    private val binding: CustomAlertDialogBinding =
        CustomAlertDialogBinding.inflate(layoutInflater)
    lateinit var button: Button
    private lateinit var loading: CustomLoadingView

    init {
        this.apply {
            button = binding.buttonCancel
            loading = binding.loadingView
            loading.colors = loadingColors
            button.setOnClickListener(this)
            setView(binding.root)
            setCancelable(false)
        }
    }

    override fun onClick(button: View) {
        this.dismiss()
        Snackbar.make(view, "Account settings not loaded", 1500).show()
    }
}