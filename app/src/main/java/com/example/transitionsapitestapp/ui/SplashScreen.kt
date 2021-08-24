package com.example.transitionsapitestapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.os.postDelayed
import com.example.transitionsapitestapp.R
import com.example.transitionsapitestapp.databinding.SplashScreenBinding

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private lateinit var animation: Animation
    private lateinit var imageAnim: ImageView
    private lateinit var binding: SplashScreenBinding
    private lateinit var firstIcon: ImageView
    private lateinit var secondIcon: ImageView
    private lateinit var thirdIcon: ImageView
    private lateinit var fourthIcon: ImageView
    private lateinit var linearLayout: LinearLayoutCompat
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            linearLayout = linearLayoutAnimation
            textView = textViewAnimation
            imageAnim = imageToAnimate
            firstIcon = firstIconAnim
            secondIcon = secondIconAnim
            thirdIcon = thirdIconAnim
            fourthIcon = fourthIconAnim
        }
        loadAnimation()

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 1700)
    }

    private fun loadAnimation() {
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)
        Handler().postDelayed(700) {
            linearLayout.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
            imageAnim.visibility = View.VISIBLE
            val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.icons_breeze_animation)
            imageAnim.startAnimation(animation)
            linearLayout.startAnimation(fadeAnimation)
            textView.startAnimation(fadeAnimation)
        }
    }
}