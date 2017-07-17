package com.jktaihe.engine.utils

import kotlin.properties.ReadWriteProperty

/**
 * Created by hzjixiaohui on 2017-6-13.
 */
object DelegatesExt{
    fun <T:Any> notNullSingleValue(): ReadWriteProperty<Any?, T> = NotNullSingleValueVar()
}

