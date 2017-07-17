package com.jktaihe.kotlin.extensions

import android.app.Activity
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import android.support.v4.app.Fragment
import android.support.v7.widget.DrawableUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import com.jktaihe.engine.utils.ImageViewUtils

/**
 * Created by hzjixiaohui on 2017-6-5.
 */

val View.ctx:Context
    get() = context

fun ImageView.loadUrl(url:Any?){
   ImageViewUtils.loadUrl(this,url)
}

fun Activity.hideKeyboard():Boolean{
    val view = currentFocus
    view?.let {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return inputMethodManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
    return false
}