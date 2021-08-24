package com.example.transitionsapitestapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.example.transitionsapitestapp.R
import com.example.transitionsapitestapp.databinding.SplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private lateinit var animation : Animation
    private lateinit var imageAnim: ImageView
    private lateinit var binding : SplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        imageAnim = binding.imageToAnimate
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)
        imageAnim.startAnimation(animation)
        val intent = Intent(this, MainActivity::class.java)
        Handler().postDelayed(1000){
            startActivity(intent)
        }
    }

}