package com.jktaihe.kotlin.net

import android.util.Log
import com.jktaihe.kotlin.domain.RequestForecastCommand
import okhttp3.MediaType
import okhttp3.RequestBody
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONObject

/**
 * Created by hzjixiaohui on 2017-6-9.
 */

class URLUtils{

    fun postNet(url:String) {
        var json = JSONObject()
        json.put("xxx","yyyy")
        val postBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"),json.toString())
        http {
            this.url = url
            this.method = "post"
            this.body = postBody
            onSuccess {
                string -> Log.i("",string)
            }
            onFail {
                e -> Log.i("",e.message)
            }
        }
    }

    fun getNet(url : String) {
        http {
            method = "get"
            onSuccess {
                string -> Log.i("",string)
            }
            onFail {
                e -> Log.i("",e.message)
            }
        }
    }

    fun getData(){
        doAsync {
            val result = RequestForecastCommand("94043").execute()
            uiThread {
                //                recycler_view.adapter = ListAdapter(result) {
//
//                }
            }
        }
    }
}
