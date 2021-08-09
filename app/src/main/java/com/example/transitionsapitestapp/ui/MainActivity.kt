package com.example.transitionsapitestapp.ui

import android.os.Bundle
import android.util.Log
import com.example.transitionsapitestapp.R
import com.example.transitionsapitestapp.data.RepositoryImpl
import com.example.transitionsapitestapp.domain.IRepository
import com.example.transitionsapitestapp.ui.viewmodels.TransitionViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var repositoryImpl: IRepository

    @Inject
    lateinit var myViewModel: TransitionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("TAG", repositoryImpl.toString())
    }
}