package com.example.transitionsapitestapp.di.modules

import androidx.lifecycle.ViewModel
import com.example.transitionsapitestapp.data.fragment.cats.repository.CatsRepository
import com.example.transitionsapitestapp.di.annotations.ViewModelKey
import com.example.transitionsapitestapp.di.scopes.CatsFragmentScope
import com.example.transitionsapitestapp.di.scopes.FragmentScope
import com.example.transitionsapitestapp.domain.CatsUseCase
import com.example.transitionsapitestapp.domain.ICatsRepository
import com.example.transitionsapitestapp.domain.ICatsUseCase
import com.example.transitionsapitestapp.ui.fragments.chosefragments.viewmodel.CatsFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class CatsFragmentModule {

    @CatsFragmentScope
    @Binds
    abstract fun bindRepository(repository: CatsRepository): ICatsRepository

    @CatsFragmentScope
    @Binds
    abstract fun bindCatsUseCase(useCase: CatsUseCase): ICatsUseCase

    @Binds
    @IntoMap
    @CatsFragmentScope
    @ViewModelKey(CatsFragmentViewModel::class)
    abstract fun getViewModel(viewModel: CatsFragmentViewModel): ViewModel

    companion object {
        @CatsFragmentScope
        @Provides
        fun provideRepository(): CatsRepository {
            return CatsRepository()
        }

        @CatsFragmentScope
        @Provides
        fun provideUseCase(repository: ICatsRepository): CatsUseCase {
            return CatsUseCase(repository)
        }

        @Provides
        @CatsFragmentScope
        fun provideViewModel(useCase: ICatsUseCase): CatsFragmentViewModel {
            return CatsFragmentViewModel(useCase)
        }
    }
}