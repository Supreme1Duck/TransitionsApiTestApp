package com.example.transitionsapitestapp

import com.example.transitionsapitestapp.di.components.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    private val applicationInjector = DaggerAppComponent.factory().create(this)
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}