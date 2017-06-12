package com.jktaihe.kotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.bean.DataBean
import com.jktaihe.kotlin.bean.ResultBean
import kotlinx.android.synthetic.main.item_recommend.view.*

/**
 * Created by hzjixiaohui on 2017-6-1.
 */

class RecomendAdapter(val datas: ResultBean, val itemClick: (DataBean) -> Unit) : RecyclerView.Adapter<RecomendAdapter.ViewHolder>() {

    var dataBeans: ResultBean? = null

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        var d: List<DataBean>? = dataBeans?.data
        d?.let {
            viewHolder.bindForecaset(d[position])
        }
    }

    override fun getItemCount(): Int = dataBeans?.data?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend, parent)
        return ViewHolder(itemView, itemClick)
    }

    class ViewHolder(view: View, val itemClick: (DataBean) -> Unit) : RecyclerView.ViewHolder(view) {
        fun bindForecaset(dataBean: DataBean) {
            with(dataBean) {
                //               itemView.to = "$date - $description - $high /$low"
                itemView.setOnClickListener {
                    itemClick(this)
                }
            }
        }
    }
}

