package com.shaunhossain.githubhiltdemo.di

import com.shaunhossain.githubhiltdemo.DataUseCase.DataUseCase
import com.shaunhossain.githubhiltdemo.repositories.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@InstallIn(ActivityRetainedComponent::class)
@Module
object UseCaseModule {
    @Provides
    fun providesUseCase(dataRepository: DataRepository): DataUseCase {
        return DataUseCase(dataRepository)
    }
}