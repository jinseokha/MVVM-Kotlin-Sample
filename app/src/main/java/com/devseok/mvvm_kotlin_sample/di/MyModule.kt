package com.devseok.mvvm_kotlin_sample.di

import com.devseok.mvvm_kotlin_sample.MainSearchRecyclerViewAdapter
import com.devseok.mvvm_kotlin_sample.model.DataModel
import com.devseok.mvvm_kotlin_sample.model.DataModelImpl
import com.devseok.mvvm_kotlin_sample.model.service.KakaoSearchService
import com.devseok.mvvm_kotlin_sample.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.koin.viewModel

import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

var retrofitPart = module {
    single<KakaoSearchService> {
        Retrofit.Builder()
            .baseUrl("https://dapi.kakao.com")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(KakaoSearchService::class.java)
    }
}

var adapterPart = module {
    factory {
        MainSearchRecyclerViewAdapter()
    }
}

var modelPart = module {
    factory<DataModel> {
        DataModelImpl(get())
    }
}

var viewModelPart = module {
    viewModel {
        MainViewModel(get())
    }
}

var myDiModule = listOf(retrofitPart, adapterPart, modelPart, viewModelPart)