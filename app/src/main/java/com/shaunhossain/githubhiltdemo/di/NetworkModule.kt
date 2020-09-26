package com.shaunhossain.githubhiltdemo.di

import com.shaunhossain.githubhiltdemo.network.ApiService
import com.shaunhossain.githubhiltdemo.utility.NetworkConstants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun providesBaseUrl() : String{
        return BASE_URL
    }

    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()

        return okHttpClient.addInterceptor(loggingInterceptor)
                .callTimeout(60,TimeUnit.SECONDS)
                .connectTimeout(60,TimeUnit.SECONDS)
                .writeTimeout(60,TimeUnit.SECONDS)
                .readTimeout(60,TimeUnit.SECONDS)
                .build()
    }

    @Provides
    fun providesConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun providesRetrofit(baseUrl : String,convertorFactory : Converter.Factory,okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(convertorFactory)
                .client(okHttpClient)
                .build()

    }

    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }




}