package com.example.transitionsapitestapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.transitionsapitestapp.data.fragment.MainFragmentRepository
import com.example.transitionsapitestapp.di.annotations.ViewModelKey
import com.example.transitionsapitestapp.di.scopes.FragmentScope
import com.example.transitionsapitestapp.domain.IMainFragmentRepository
import com.example.transitionsapitestapp.domain.IWeatherUseCase
import com.example.transitionsapitestapp.domain.WeatherUseCase
import com.example.transitionsapitestapp.ui.fragments.viewmodels.MainFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class MainFragmentModule {

    @Binds
    @FragmentScope
    abstract fun provideUseCaseInterface(useCase: WeatherUseCase): IWeatherUseCase

    @Binds
    @FragmentScope
    abstract fun provideRepositoryUseCase(repository: MainFragmentRepository): IMainFragmentRepository

    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class)
    abstract fun getViewModel(viewModel: MainFragmentViewModel): ViewModel

    companion object {
        @Provides
        @FragmentScope
        fun provideViewModel(useCase: IWeatherUseCase): MainFragmentViewModel {
            return MainFragmentViewModel(useCase)
        }

        @Provides
        @FragmentScope
        fun provideWeatherUseCase(repository: IMainFragmentRepository): WeatherUseCase {
            return WeatherUseCase(repository)
        }

        @Provides
        @FragmentScope
        fun provideRepository(): MainFragmentRepository {
            return MainFragmentRepository()
        }
    }
}