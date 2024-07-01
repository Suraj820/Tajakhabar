package com.example.tajakhabar.data.remote

import com.example.tajakhabar.data.remote.dto.NewsResponse
import com.example.tajakhabar.utils.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsAPI {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page:Int,
        @Query("sources") string: String,
        @Query("apiKey") apiKey:String= API_KEY
    ): NewsResponse

}