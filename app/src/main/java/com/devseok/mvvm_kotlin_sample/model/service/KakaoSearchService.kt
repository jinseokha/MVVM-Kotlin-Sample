package com.devseok.mvvm_kotlin_sample.model.service

import com.devseok.mvvm_kotlin_sample.model.DataModel
import com.devseok.mvvm_kotlin_sample.model.DataModelImpl
import com.devseok.mvvm_kotlin_sample.model.response.ImageSearchResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface KakaoSearchService {
    @GET("/v2/search/image")
    fun searchImage(
        @Header("Authorization") auth:String,
        @Query("query") query:String,
        @Query("sort") sort:String,
        @Query("page") page:Int,
        @Query("size") size:Int
    ): Single<ImageSearchResponse>
}