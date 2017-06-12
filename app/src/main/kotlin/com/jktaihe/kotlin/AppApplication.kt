package com.jktaihe.kotlin

import android.app.Application
import com.jktaihe.engine.APIHOST

/**
 * Created by hzjixiaohui on 2017-6-5.
 */
class AppApplication :Application(){

    companion object{
        private var instance: AppApplication? = null
        fun instance() = instance

    }

    override fun onCreate() {
        super.onCreate()
        APIHOST.BaseHost = BuildConfig.API_HOST
        instance = this
    }

}