package com.jindal.retrofit_0704.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.jindal.retrofit_0704.model.Quotes
import com.jindal.retrofit_0704.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuotesRepository) :ViewModel(){
    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getQuotes(1)
        }
    }

    val quotesData : LiveData <Quotes>
        get() = repository.QuotesLiveData
}