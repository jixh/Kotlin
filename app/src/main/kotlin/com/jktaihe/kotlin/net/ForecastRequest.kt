package com.jktaihe.kotlin.net

import com.google.gson.Gson
import com.jktaihe.kotlin.bean.ForecastResult
import java.net.URL

/**
 * Created by hzjixiaohui on 2017-6-1.
 */
class ForecastRequest(val zipCode:String) {

    companion object{
        private var APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private var URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execulte():ForecastResult{
        val  forecastStr =  URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastStr,ForecastResult::class.java)
    }
}