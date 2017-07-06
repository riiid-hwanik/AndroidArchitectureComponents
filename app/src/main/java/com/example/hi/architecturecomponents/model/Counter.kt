package com.example.hi.architecturecomponents.model

import io.reactivex.subjects.PublishSubject

/**
 * Created by hi on 2017. 7. 6..
 */

class Counter constructor(private var number: Int = 0) {
    private var ps = PublishSubject.create<Int>()

    fun getCount(): PublishSubject<Int> {
        return ps
    }

    fun increase() {
        ps.onNext(++number)
    }

    fun decrease() {
        ps.onNext(--number)
    }
}
