package com.example.transitionsapitestapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.transitionsapitestapp.data.fragment.news.repository.NewsRepository
import com.example.transitionsapitestapp.di.annotations.ViewModelKey
import com.example.transitionsapitestapp.di.scopes.CatsFragmentScope
import com.example.transitionsapitestapp.di.scopes.NewsFragmentScope
import com.example.transitionsapitestapp.domain.INewsRepository
import com.example.transitionsapitestapp.domain.INewsUseCase
import com.example.transitionsapitestapp.domain.NewsUseCase
import com.example.transitionsapitestapp.ui.fragments.chosefragments.viewmodel.NewsFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class NewsFragmentModule {

    @NewsFragmentScope
    @Binds
    abstract fun bindRepository(repository: NewsRepository): INewsRepository

    @NewsFragmentScope
    @Binds
    abstract fun bindCatsUseCase(useCase: NewsUseCase): INewsUseCase

    @Binds
    @IntoMap
    @NewsFragmentScope
    @ViewModelKey(NewsFragmentViewModel::class)
    abstract fun getViewModel(viewModel: NewsFragmentViewModel): ViewModel

    companion object {
        @NewsFragmentScope
        @Provides
        fun provideRepository(): NewsRepository {
            return NewsRepository()
        }

        @NewsFragmentScope
        @Provides
        fun provideUseCase(repository: INewsRepository): NewsUseCase {
            return NewsUseCase(repository)
        }

        @Provides
        @NewsFragmentScope
        fun provideViewModel(useCase: INewsUseCase): NewsFragmentViewModel {
            return NewsFragmentViewModel(useCase)
        }
    }

}