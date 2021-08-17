package com.example.transitionsapitestapp.di.modules

import com.example.transitionsapitestapp.data.fragment.cats.repository.CatsRepository
import com.example.transitionsapitestapp.di.scopes.FragmentScope
import com.example.transitionsapitestapp.domain.CatsUseCase
import com.example.transitionsapitestapp.domain.ICatsRepository
import com.example.transitionsapitestapp.domain.ICatsUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
abstract class CatsFragmentModule {

    @FragmentScope
    @Binds
    abstract fun bindRepository(repository: CatsRepository): ICatsRepository

    @FragmentScope
    @Binds
    abstract fun bindCatsUseCase(useCase: CatsUseCase): ICatsUseCase

    companion object {
        @FragmentScope
        @Provides
        fun provideRepository(): CatsRepository {
            return CatsRepository()
        }

        @FragmentScope
        @Provides
        fun provideUseCase(repository: ICatsRepository): CatsUseCase {
            return CatsUseCase(repository)
        }
    }

}