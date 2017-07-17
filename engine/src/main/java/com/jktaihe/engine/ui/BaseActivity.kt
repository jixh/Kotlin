package com.jktaihe.engine.ui

import android.support.v7.app.AppCompatActivity

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

abstract class BaseActivity : AppCompatActivity(),InstanceView,LoadView{

    override fun loadError() {

    }

    override fun loadSuccess() {

    }

    override fun loadFinish() {

    }


}
