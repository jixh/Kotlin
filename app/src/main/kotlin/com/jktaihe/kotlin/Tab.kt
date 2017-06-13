package com.jktaihe.kotlin

import com.jktaihe.kotlin.ui.fragment.GirlFragment
import com.jktaihe.kotlin.ui.fragment.HistoryFragment
import com.jktaihe.kotlin.ui.fragment.RecommendFragment

/**
 * Created by hzjixiaohui on 2017-6-7.
 */
enum class Tab constructor(var clz: Class<*>,val tabName:String){
    RECOMMEND(RecommendFragment::class.java,"推荐"),
    GIRL(GirlFragment::class.java,"妹子"),
    HISTORY(HistoryFragment::class.java,"消息")
}
