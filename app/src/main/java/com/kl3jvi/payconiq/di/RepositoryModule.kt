package com.kl3jvi.payconiq.di

import com.kl3jvi.payconiq.data.remote.repository.SearchRepositoryImpl
import com.kl3jvi.payconiq.data.remote.repository.UserDetailsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class RepositoryModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun bindFavoritesRepository(repository: UserDetailsRepositoryImpl): FavoritesRepository

    @ActivityRetainedScoped
    @Binds
    abstract fun bindSearchRepository(repository: SearchRepositoryImpl): SearchRepository


}