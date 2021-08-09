package com.example.transitionsapitestapp.di.modules

import com.example.transitionsapitestapp.di.scopes.ActivityScope
import com.example.transitionsapitestapp.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

}