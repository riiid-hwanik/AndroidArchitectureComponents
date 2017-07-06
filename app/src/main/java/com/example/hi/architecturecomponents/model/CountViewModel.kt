package com.example.hi.architecturecomponents.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log

/**
 * Created by hi on 2017. 7. 6..
 */

class UserViewModel : ViewModel() {

    private val TAG: String = this::class.java.simpleName
    private var number = 0
    private var count: MutableLiveData<Int> = MutableLiveData()

    fun getCount(): LiveData<Int> {
        return count
    }

    fun increase() {
        count.value = ++number
    }

    fun decrease() {
        count.value = --number
    }


    /**
     * ViewModel이 더이상 사용되지 않고 파괴딜 때 호출
     */
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
    }
}
