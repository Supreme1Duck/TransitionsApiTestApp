package com.example.transitionsapitestapp.di.components

import com.example.transitionsapitestapp.data.RepositoryImpl
import com.example.transitionsapitestapp.di.scopes.ActivityScope
import com.example.transitionsapitestapp.domain.IRepository
import com.example.transitionsapitestapp.ui.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent
import dagger.android.AndroidInjector

//@ActivityScope
//@Subcomponent
//interface ActivityComponent : AndroidInjector<MainActivity> {
//
//    @Subcomponent.Factory
//    interface Factory {
//        fun create(@BindsInstance activity: MainActivity): ActivityComponent
//    }
//}