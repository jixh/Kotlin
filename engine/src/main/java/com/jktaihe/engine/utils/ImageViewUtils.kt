package com.jktaihe.engine.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.jktaihe.engine.R

/**
 * Created by hzjixiaohui on 2017-6-14.
 */
object ImageViewUtils :IImageView{
    override fun loadUrl(iv: ImageView, url:Any?) {
          Glide.with(iv.context).load(url).into(iv).onLoadFailed(iv.context.resources.getDrawable(R.drawable.girl))
    }
}