package com.jktaihe.kotlin.ui.adapter

import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.bean.GankBean
import com.jktaihe.kotlin.extensions.loadUrl
import kotlinx.android.synthetic.main.item_recommend.view.*

/**
 * Created by hzjixiaohui on 2017-6-1.
 */

class GankAdapter(itemClick: (GankBean) -> Unit) : JktaiheBaseAdapter<GankBean>(itemClick) {

    override fun itemLayoutId(viewType : Int): Int {
        return R.layout.item_recommend
    }

    override fun bindViewHolder(viewHolder: ViewHolder,dataBean: GankBean) {
        with(dataBean) {
            viewHolder.itemView.tv_text.text = """简介:
$desc"""
            viewHolder.itemView.iv_show.loadUrl("${dataBean.images?.get(0)}?imageView2/0/w/400")
        }
    }

}

