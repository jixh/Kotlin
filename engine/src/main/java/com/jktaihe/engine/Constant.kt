package com.jktaihe.engine

import com.jktaihe.engine.APIHOST.Companion.BaseHost

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

class Constant{
    companion object{
        val BaseURL:String = BaseHost+ "api/"
    }
}

class APIHOST{
    companion object {
        var BaseHost: String? = null
    }
}