package com.example.transitionsapitestapp.utils

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import com.example.transitionsapitestapp.databinding.CustomAlertDialogBinding
import com.google.android.material.snackbar.Snackbar

class CustomAlertDialog(
    context: Context,
    val view: View
) : AlertDialog(context), View.OnClickListener {

    private val binding: CustomAlertDialogBinding =
        CustomAlertDialogBinding.inflate(layoutInflater)
    lateinit var button: Button
    private lateinit var image: ImageView

    init {
        this.apply {
            button = binding.buttonCancel
            image = binding.imageLoading
            button.setOnClickListener(this)
            setView(binding.root)
            setCancelable(false)
        }
        animateImageView()
    }

    override fun onClick(button: View) {
        this.dismiss()
        Snackbar.make(view, "Account settings not loaded", 1500).show()
    }

    private fun animateImageView() {
        val animation =
            RotateAnimation(0F, 720F, 65f, 67f)
                .apply {
                    interpolator = LinearInterpolator()
                    repeatCount = Animation.INFINITE
                    repeatMode = Animation.REVERSE
                    duration = 1000L
                }
        image.startAnimation(animation)
    }
}