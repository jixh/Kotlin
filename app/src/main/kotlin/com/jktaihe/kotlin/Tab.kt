package com.jktaihe.kotlin

import com.jktaihe.kotlin.ui.fragment.GirlFragment
import com.jktaihe.kotlin.ui.fragment.RecommendFragment

/**
 * Created by hzjixiaohui on 2017-6-7.
 */
enum class Tab constructor(var clz: Class<*>){
    RECOMMEND(RecommendFragment::class.java),
    GIRL(GirlFragment::class.java),
    HISTORY(GirlFragment::class.java)
}
