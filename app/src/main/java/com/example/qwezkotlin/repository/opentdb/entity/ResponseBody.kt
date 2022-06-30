package com.example.qwezkotlin.repository.opentdb.entity

import com.google.gson.annotations.SerializedName

data class ResponseBody(
    @SerializedName("response_code")
    val responseCode: Int,
    @SerializedName("results")
    val questions: List<Question>
)
