package com.jktaihe.kotlin.bean

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
                    val used: Boolean = false,
                    val who: String?)