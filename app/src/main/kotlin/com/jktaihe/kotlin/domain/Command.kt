package com.jktaihe.kotlin.domain

import com.jktaihe.kotlin.net.ForecastRequest

/**
 * Created by hzjixiaohui on 2017-6-5.
 */


interface Command<T> {
    fun execute(): T
}

class RequestForecastCommand(val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execulte())
    }
}