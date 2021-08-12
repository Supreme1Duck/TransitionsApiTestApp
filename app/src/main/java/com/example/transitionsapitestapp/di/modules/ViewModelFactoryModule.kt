package com.example.transitionsapitestapp.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.transitionsapitestapp.di.viewmodel_factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}