package com.shaunhossain.githubhiltdemo.repositories

import com.shaunhossain.githubhiltdemo.model.GitHubDataModel
import com.shaunhossain.githubhiltdemo.network.ApiService
import javax.inject.Inject

class DataRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getRepositoryData(): GitHubDataModel {
        return apiService.getData()
    }
}