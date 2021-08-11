package com.example.transitionsapitestapp.di.modules

import com.example.transitionsapitestapp.data.Database
import com.example.transitionsapitestapp.di.scopes.ActivityScope
import com.example.transitionsapitestapp.ui.MainActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
abstract class AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModule::class])
    abstract fun contributeMainActivity(): MainActivity

    companion object {
        @Singleton
        @Provides
        fun getDatabase(): Database {
            return Database()
        }
    }
}