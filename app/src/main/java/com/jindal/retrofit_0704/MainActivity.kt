package com.jindal.retrofit_0704

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import com.jindal.retrofit_0704.api.QuotesService
import com.jindal.retrofit_0704.api.RetrofitHelper
import com.jindal.retrofit_0704.repository.QuotesRepository
import com.jindal.retrofit_0704.viewModel.MainViewModel
import com.jindal.retrofit_0704.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // code to run
        val quotesService = RetrofitHelper.getInstance().create(QuotesService::class.java)
        val repository = QuotesRepository(quotesService)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.quotesData.observe(this , Observer{
            Log.d("CheezyCode", it.results.toString())

        })

    }
}