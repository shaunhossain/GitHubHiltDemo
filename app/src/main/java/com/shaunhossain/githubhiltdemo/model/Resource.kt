package com.shaunhossain.githubhiltdemo.model

sealed class Resource<out T> {
    data class Success<out T>(val data: T? = null): Resource<T>()
    data class Loading(val nothing: Nothing? = null): Resource<Nothing>()
    data class Error(val message: String? = null): Resource<Nothing>()
    data class Exception(val message: String? = null): Resource<Nothing>()
}