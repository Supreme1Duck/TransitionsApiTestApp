package com.example.transitionsapitestapp.ui

import android.os.Bundle
import android.util.Log
import com.example.transitionsapitestapp.R
import com.example.transitionsapitestapp.data.RepositoryImpl
import com.example.transitionsapitestapp.domain.IRepository
import com.example.transitionsapitestapp.domain.IUseCase
import com.example.transitionsapitestapp.ui.viewmodels.TransitionViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject
import javax.inject.Named

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}