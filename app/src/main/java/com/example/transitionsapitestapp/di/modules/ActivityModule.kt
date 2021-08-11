package com.example.transitionsapitestapp.di.modules

import com.example.transitionsapitestapp.data.Database
import com.example.transitionsapitestapp.data.RepositoryImpl
import com.example.transitionsapitestapp.di.scopes.ActivityScope
import com.example.transitionsapitestapp.domain.IRepository
import com.example.transitionsapitestapp.domain.IUseCase
import com.example.transitionsapitestapp.domain.UseCase
import com.example.transitionsapitestapp.ui.fragments.MainFragment
import com.example.transitionsapitestapp.ui.viewmodels.TransitionViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Named

@Module
abstract class ActivityModule {

    companion object {
        @ActivityScope
        @Provides
        fun getRepository(database: Database): RepositoryImpl {
            return RepositoryImpl(database)
        }

        @ActivityScope
        @Provides
        fun getViewModel(useCase: IUseCase): TransitionViewModel {
            return TransitionViewModel(useCase)
        }

        @ActivityScope
        @Provides
        fun getUseCase(repository: IRepository): UseCase {
            return UseCase(repository = repository)
        }
    }

    @ActivityScope
    @Binds
    abstract fun getRepositoryInterface(repositoryImpl: RepositoryImpl): IRepository

    @ActivityScope
    @Named("MainActivity")
    @Binds
    abstract fun getUseCaseInterface(useCase: UseCase): IUseCase

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun contributeFragmentModule(): MainFragment
}