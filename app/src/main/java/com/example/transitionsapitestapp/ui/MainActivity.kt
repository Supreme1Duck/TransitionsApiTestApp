package com.example.transitionsapitestapp.ui

import android.os.Bundle
import com.example.transitionsapitestapp.R
import com.google.firebase.auth.FirebaseUser
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    var currentUser : FirebaseUser? = null
    private lateinit var intentExtra : Pair<Boolean, FirebaseUser?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intentExtra = intent.getSerializableExtra("User") as Pair<Boolean, FirebaseUser?>
        currentUser = if (intentExtra.first) intentExtra.second else null
    }
}