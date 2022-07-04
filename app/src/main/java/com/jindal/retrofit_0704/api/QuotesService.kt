package com.jindal.retrofit_0704.api

import com.jindal.retrofit_0704.model.Quotes
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesService {
    @GET("/quotes")
    suspend fun getQuote(@Query("page")page:Int) : Response<Quotes>
}