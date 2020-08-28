package com.devseok.mvvm_kotlin_sample.model

import com.devseok.mvvm_kotlin_sample.model.enum.KakaoSearchSortEnum
import com.devseok.mvvm_kotlin_sample.model.response.ImageSearchResponse
import io.reactivex.Single

interface DataModel {
    fun getData(query: String, sort: KakaoSearchSortEnum, page: Int, size: Int): Single<ImageSearchResponse>
}