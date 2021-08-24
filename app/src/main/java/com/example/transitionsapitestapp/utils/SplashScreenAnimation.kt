package com.example.transitionsapitestapp.utils

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup

@SuppressLint("CustomSplashScreen")
class SplashScreenAnimation(val id: Int, val parent: ViewGroup) {

    fun animate() {
        val view = parent.findViewById<View>(id)
    }

}