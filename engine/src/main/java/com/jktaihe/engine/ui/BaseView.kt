package com.jktaihe.engine.ui

import android.os.Bundle

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

interface BaseView {

    fun layoutId():Int

    fun initView(savedInstanceState: Bundle?)

    companion object {
        @Throws(IllegalAccessException::class, java.lang.InstantiationException::class)
        fun <T> createInstance(clazz: Class<T>): T {
            return clazz.newInstance()
        }
    }
}
