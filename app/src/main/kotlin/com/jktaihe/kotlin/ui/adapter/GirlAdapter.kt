package com.jktaihe.kotlin.ui.adapter

import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.bean.GankBean
import com.jktaihe.kotlin.extensions.loadUrl
import kotlinx.android.synthetic.main.item_girl.view.*

/**
 * Created by hzjixiaohui on 2017-6-13.
 */
class GirlAdapter(itemClick: (GankBean) -> Unit) : JktaiheBaseAdapter<GankBean>(itemClick) {

    override fun itemLayoutId(viewType:Int): Int {
       return R.layout.item_girl
    }

    override fun bindViewHolder(viewHolder: ViewHolder, dataBean: GankBean) {
        with(dataBean){
            viewHolder.itemView.iv_show.loadUrl("${dataBean.url}?imageView2/0/w/600")
        }
    }
}