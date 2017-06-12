package com.jktaihe.engine.data

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

public interface BaseModel<T> {

    fun loadData()

    fun loadError()

    fun loadSuccess(t : T)

}
