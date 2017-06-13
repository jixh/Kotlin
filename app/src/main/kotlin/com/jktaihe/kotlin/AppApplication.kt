package com.jktaihe.kotlin

import android.app.Application
import com.jktaihe.engine.APIHOST
import com.jktaihe.engine.utils.DelegatesExt

/**
 * Created by hzjixiaohui on 2017-6-5.
 */
class AppApplication :Application(){

    companion object{
        var instance: AppApplication by DelegatesExt.notNullSingleValue<AppApplication>()
    }

    override fun onCreate() {
        super.onCreate()
        APIHOST.BaseHost = BuildConfig.API_HOST
        instance = this
    }

}