package com.flany.paging.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author: hec@shuyilink.com
 * @date:   2021/7/19
 * @since:
 */
open class BaseViewModel : ViewModel() {

    val commonEvent = CommonEvent()

    fun showLoading() {
        commonEvent.showLoading.postValue(true)
    }

    fun dismissLoading() {
        commonEvent.showLoading.postValue(false)
    }

    inner class CommonEvent {
        val showLoading = MutableLiveData(false)
    }
}