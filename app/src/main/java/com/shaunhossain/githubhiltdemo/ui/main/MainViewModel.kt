package com.shaunhossain.githubhiltdemo.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.shaunhossain.githubhiltdemo.DataUseCase.DataUseCase
import com.shaunhossain.githubhiltdemo.model.GitHubDataModel
import com.shaunhossain.githubhiltdemo.model.Resource

class MainViewModel @ViewModelInject constructor(private val useCase: DataUseCase) : ViewModel() {
    fun getRepositoryList(): LiveData<Resource<GitHubDataModel>> {

      return liveData<Resource<GitHubDataModel>> {
           emit(Resource.Loading())
           emit(useCase.getRepositoryList())
       }
        //useCase.getRepositoryList()
    }
}