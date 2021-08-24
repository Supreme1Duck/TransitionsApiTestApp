package com.example.transitionsapitestapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
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
        val intent = Intent(this, MainActivity::class.java)
        Handler().postDelayed(1400) {
            startActivity(intent)
        }
    }

    private fun loadAnimation() {
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)
        Handler().postDelayed(500) {
            textView.visibility = View.VISIBLE
            linearLayout.visibility = View.VISIBLE
            imageAnim.visibility = View.VISIBLE
            imageAnim.startAnimation(animation)
            val imageAnimation = AnimationUtils.loadAnimation(this, R.anim.icons_breeze_animation)
            firstIcon.startAnimation(imageAnimation)
            secondIcon.startAnimation(imageAnimation)
            thirdIcon.startAnimation(imageAnimation)
            fourthIcon.startAnimation(imageAnimation)
        }
    }
}