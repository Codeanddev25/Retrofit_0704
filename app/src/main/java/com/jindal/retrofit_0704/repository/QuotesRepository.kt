package com.jindal.retrofit_0704.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jindal.retrofit_0704.model.Quotes
import com.jindal.retrofit_0704.api.QuotesService

class QuotesRepository(private val quotesService : QuotesService) {

    private val mutableQuotesLiveData = MutableLiveData<Quotes>()

    val quotesLiveData : LiveData<Quotes>
    get() = mutableQuotesLiveData

    suspend fun getQuotes(page : Int){
        val result = quotesService.getQuote(page)
        if(result?.body() != null) {
            mutableQuotesLiveData.postValue(result.body())
        }
    }

}