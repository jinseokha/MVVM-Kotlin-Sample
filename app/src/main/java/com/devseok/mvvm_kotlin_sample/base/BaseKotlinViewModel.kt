package com.devseok.mvvm_kotlin_sample.base

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.devseok.mvvm_kotlin_sample.util.SnackbarMessage
import com.devseok.mvvm_kotlin_sample.util.SnackbarMessageString
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseKotlinViewModel : ViewModel() {
    private val snackbarMessage = SnackbarMessage()
    private val snackbarMessageString = SnackbarMessageString()

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }


    fun observeSnackbarMessage(lifecycleOwner: LifecycleOwner, ob: (Int) -> Unit) {
        snackbarMessage.observe(lifecycleOwner, ob)
    }

    fun observeSnackbarMessageStr(lifecycleOwner: LifecycleOwner, ob: (String) -> Unit) {
        snackbarMessageString.observe(lifecycleOwner, ob)
    }

}