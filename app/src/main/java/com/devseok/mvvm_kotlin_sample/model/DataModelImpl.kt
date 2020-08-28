package com.devseok.mvvm_kotlin_sample.model

import com.devseok.mvvm_kotlin_sample.model.enum.KakaoSearchSortEnum
import com.devseok.mvvm_kotlin_sample.model.response.ImageSearchResponse
import com.devseok.mvvm_kotlin_sample.model.service.KakaoSearchService
import io.reactivex.Single



class DataModelImpl(private val service: KakaoSearchService): DataModel {

    private val KAKAO_APP_KEY = "YOUR_APP_KEY"

    override fun getData(query: String, sort: KakaoSearchSortEnum, page: Int, size: Int): Single<ImageSearchResponse> {
        return service.searchImage(auth = "KakaoAK $KAKAO_APP_KEY", query = query, sort = sort.sort, page = page, size = size)
    }
}