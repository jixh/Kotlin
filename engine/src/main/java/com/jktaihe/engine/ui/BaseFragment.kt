package com.jktaihe.engine.ui

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

abstract class BaseFragment : Fragment(), BaseView ,LoadView{

    var activity: Activity? = null
    var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            rootView = inflater!!.inflate(layoutId(), container, false)
        }
        Log.i(this.javaClass.simpleName,"onCreateView")
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.activity = context as AppCompatActivity
        Log.i(this.javaClass.simpleName,"onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        this.activity = null
        Log.i(this.javaClass.simpleName,"onDetach")
    }

    override fun loadError() {

    }

    override fun loadSuccess() {
        
    }

    override fun loadFinish() {

    }

}
