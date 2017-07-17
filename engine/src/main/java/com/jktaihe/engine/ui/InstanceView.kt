package com.jktaihe.engine.ui


/**
 * Created by hzjixiaohui on 2017-6-7.
 */

interface InstanceView{
    companion object {
        @Throws(IllegalAccessException::class, java.lang.InstantiationException::class)
        fun <T> createInstance(clazz: Class<T>): T {
            return clazz.newInstance()
        }
    }
}
