package com.example.hi.architecturecomponents.model

import android.arch.lifecycle.ViewModel
import android.util.Log
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by hi on 2017. 7. 6..
 */

class UserViewModel constructor(private var number: Int = 0) : ViewModel() {
    private val TAG: String = this::class.java.simpleName
    private var sj = BehaviorSubject.create<Int>()

    fun getCount(): BehaviorSubject<Int> {
        return sj
    }

    fun increase() {
        sj.onNext(++number)
    }

    fun decrease() {
        sj.onNext(--number)
    }

    /**
     * ViewModel이 더이상 사용되지 않고 파괴딜 때 호출
     */
    override fun onCleared() {
        super.onCleared()
        Log.d(TAG, "onCleared")
    }
}
