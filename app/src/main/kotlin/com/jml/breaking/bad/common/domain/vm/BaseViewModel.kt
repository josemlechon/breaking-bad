package com.jml.breaking.bad.common.domain.vm

import androidx.annotation.CallSuper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val loadingLiveData = MutableLiveData<Boolean>()

    protected fun blockScreen(show: Boolean = true) {
        loadingLiveData.value = show
    }

    fun getLoadingLiveData(): LiveData<Boolean> = loadingLiveData

}