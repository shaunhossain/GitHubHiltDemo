package com.shaunhossain.githubhiltdemo.DataUseCase

import com.shaunhossain.githubhiltdemo.model.GitHubDataModel
import com.shaunhossain.githubhiltdemo.model.Resource
import com.shaunhossain.githubhiltdemo.repositories.DataRepository
import okio.IOException
import javax.inject.Inject

class DataUseCase @Inject constructor(private val dataRepository: DataRepository) {

    suspend fun getRepositoryList(): Resource<GitHubDataModel> {

        val getPublicRepositoryList =  dataRepository.getRepositoryData()

        val resultData = try{
            if(!getPublicRepositoryList.isNullOrEmpty()){
                Resource.Success(getPublicRepositoryList)
            }else{
                Resource.Error("Service not found")
            }
        }catch(t : Throwable ){
            when(t){
                is IOException -> Resource.Exception("Network fail")
                else -> Resource.Exception("Internal Problem")
            }

        }

        return resultData
    }

}