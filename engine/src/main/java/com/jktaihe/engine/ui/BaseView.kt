package com.jktaihe.engine.ui

import android.os.Bundle
import android.support.annotation.LayoutRes

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

interface BaseView{

    @LayoutRes fun layoutId():Int

    fun initView(savedInstanceState: Bundle?)
}
