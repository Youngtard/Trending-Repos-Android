package com.youngtard.githubtrendingandroid.network

import com.youngtard.githubtrendingandroid.model.Repo
import com.youngtard.githubtrendingandroid.model.Resp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface GithubApiService {

    @GET("search/repositories?q=topic:android+language:kotlin")
    fun getTrendingKotlin(): Call<Resp>

    @GET("search/repositories?q=topic:android+language:java")
    fun getTrendingJava(): Call<Resp>
}