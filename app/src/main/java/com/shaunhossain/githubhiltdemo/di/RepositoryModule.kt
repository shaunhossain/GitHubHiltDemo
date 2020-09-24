package com.shaunhossain.githubhiltdemo.di

import com.shaunhossain.githubhiltdemo.network.ApiService
import com.shaunhossain.githubhiltdemo.repositories.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@InstallIn(ActivityRetainedComponent::class)
@Module
object RepositoryModule {
    @Provides
    fun providesDataRepos(apiService: ApiService): DataRepository {
        return DataRepository(apiService)
    }

}