package com.example.qwezkotlin.data.remote

import com.example.qwezkotlin.data.remote.entity.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenTDBAPI {

    @GET("api.php?")
    fun getQuestions(
        @Query("amount") amount: Int ,
        @Query("category") category: Int,
        @Query("difficulty") difficulty: String,
        @Query("type") type: String
    ): Response<ResponseBody>
}