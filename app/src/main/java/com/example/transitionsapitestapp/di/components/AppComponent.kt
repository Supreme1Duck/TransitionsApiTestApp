package com.example.transitionsapitestapp.di.components

import android.content.Context
import com.example.transitionsapitestapp.App
import com.example.transitionsapitestapp.di.modules.AppModule
import com.example.transitionsapitestapp.di.modules.ViewModelFactoryModule
import com.example.transitionsapitestapp.ui.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ViewModelFactoryModule::class])
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}