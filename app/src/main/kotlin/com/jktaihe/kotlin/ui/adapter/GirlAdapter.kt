package com.jktaihe.kotlin.ui.adapter

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.bean.GankBean
import kotlinx.android.synthetic.main.item_girl.view.*

/**
 * Created by hzjixiaohui on 2017-6-13.
 */
class GirlAdapter(datas: List<GankBean>, itemClick: (GankBean) -> Unit) : JktaiheBaseAdapter<GankBean>(datas, itemClick) {

    override fun itemLayoutId(): Int {
       return R.layout.item_girl
    }

    override fun bindViewHolder(viewHolder: ViewHolder, dataBean: GankBean) {
        with(dataBean){
            viewHolder.itemView.tv_text.text = desc
        }
    }
}