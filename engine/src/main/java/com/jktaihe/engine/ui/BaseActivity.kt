package com.jktaihe.engine.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

abstract class BaseActivity : AppCompatActivity(),BaseView,LoadView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView(savedInstanceState)
    }

    override fun loadError() {

    }

    override fun loadSuccess() {

    }

    override fun loadFinish() {

    }


}
