package com.jktaihe.kotlin.ui.adapter

import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.bean.GankBean
import kotlinx.android.synthetic.main.item_recommend.view.*

/**
 * Created by hzjixiaohui on 2017-6-1.
 */

class GankAdapter(datas: List<GankBean>, itemClick: (GankBean) -> Unit) : JktaiheBaseAdapter<GankBean>(datas, itemClick) {

    override fun itemLayoutId(): Int {
        return R.layout.item_recommend
    }

    override fun bindViewHolder(viewHolder: ViewHolder,dataBean: GankBean) {
        with(dataBean) {
            viewHolder.itemView.tv_text.text = desc
        }
    }

}

