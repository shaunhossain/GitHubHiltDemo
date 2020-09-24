package com.shaunhossain.githubhiltdemo.network

import com.shaunhossain.githubhiltdemo.model.GitHubDataModel
import com.shaunhossain.githubhiltdemo.model.GitHubDataModelItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("repositories")
    suspend fun getData() : GitHubDataModel

    //Response<List<GitHubDataModelItem>>
}