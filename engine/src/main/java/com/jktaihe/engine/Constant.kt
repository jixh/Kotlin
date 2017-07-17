package com.jktaihe.engine

import com.jktaihe.engine.APIHOST.BaseHost


/**
 * Created by hzjixiaohui on 2017-6-7.
 */

object Constant{
    val BaseURL:String = BaseHost+ "api/"
}

object APIHOST{
    lateinit var BaseHost:String
}