package com.jktaihe.kotlin.bean

import kotlin.coroutines.experimental.EmptyCoroutineContext.plus
import kotlin.properties.Delegates
import kotlin.properties.Delegates.observable
import kotlin.properties.Delegates.vetoable

/**
 * Created by hzjixiaohui on 2017-6-8.
 */

data class ResultBean(val data: List<DataBean>?)

data class DataBean(
        val content: String?,
        val hashId: String?,
        val unixtime: Int = 0,
        val updatetime: String?
)

data class GankBean(val _id: String?,
                    val createdAt: String?,
                    val desc: String?,
                    val publishedAt: String?,
                    val source: String?,
                    val type: String?,
                    val url: String?,
                    val images:List<String>?,
                    val used: Boolean = false,
                    val who: String?)


data class UserBean(val id:String){

    var username :String by observable("用户"){
        d,old,new
        -> print(old)
    }

    var age  by vetoable<Int>(0){
        d,old,new
                ->
        print(old.toString())
        new >12
    }

    var loves : Loves = Loves(mapOf(
            "movie" to "av",
            "singing" to "av"
    ))

}

class Loves(map:Map<String,Any?>){
    val movie:String by map
    val singing:String by map
}

