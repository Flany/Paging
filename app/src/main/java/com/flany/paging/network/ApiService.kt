package com.flany.paging.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/15
 * @since:
 */
interface ApiService {

    @GET("search/repositories?sort=stars&q=Android")
    suspend fun searchRepository(@Query("page") page: Int, @Query("per_page") perPage: Int): ApiResponse

    companion object {
        private const val BASE_URL = "https://api.github.com/"

        fun create(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}