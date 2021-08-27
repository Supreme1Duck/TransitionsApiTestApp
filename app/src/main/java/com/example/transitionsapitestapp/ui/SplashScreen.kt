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
import com.example.transitionsapitestapp.utils.Color
import com.example.transitionsapitestapp.utils.CustomLoadingDialogView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    private lateinit var animation: Animation
    private lateinit var binding: SplashScreenBinding
    private lateinit var firstIcon: ImageView
    private lateinit var secondIcon: ImageView
    private lateinit var thirdIcon: ImageView
    private lateinit var fourthIcon: ImageView
    private lateinit var linearLayout: LinearLayoutCompat
    private lateinit var textView: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var customDialogView: CustomLoadingDialogView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            linearLayout = linearLayoutAnimation
            textView = textViewAnimation
            firstIcon = firstIconAnim
            secondIcon = secondIconAnim
            thirdIcon = thirdIconAnim
            fourthIcon = fourthIconAnim
            customDialogView = customView
        }
        auth = FirebaseAuth.getInstance()
        loadAnimation()

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            val extra = getCurrentUser()
            intent.putExtra("User", extra)
            startActivity(intent)
            finish()
        }, 1700)
    }

    private fun loadAnimation() {
        animation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation)
        Handler().postDelayed(700) {
            customDialogView.colors = listOf(Color.Red, Color.Green, Color.Black)
            linearLayout.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
            val fadeAnimation = AnimationUtils.loadAnimation(this, R.anim.icons_breeze_animation)
            linearLayout.startAnimation(fadeAnimation)
            textView.startAnimation(fadeAnimation)
        }
    }

    private fun getCurrentUser(): Pair<Boolean, FirebaseUser?> {
        val currentUser = auth.currentUser
        val bool = currentUser != null
        return Pair(bool, currentUser)
    }
}