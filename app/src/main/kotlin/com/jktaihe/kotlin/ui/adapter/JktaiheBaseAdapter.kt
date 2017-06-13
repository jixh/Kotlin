package com.jktaihe.kotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by hzjixiaohui on 2017-6-1.
 */

abstract  class JktaiheBaseAdapter<T>(val datas: List<T>, val itemClick: (T) -> Unit) : RecyclerView.Adapter<JktaiheBaseAdapter<T>.ViewHolder>() {

    var dataList: List<T>? =  null

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
            dataList.let {
                val databean = dataList!![position]
                viewHolder.setViewHolder(databean)
                viewHolder.itemView.setOnClickListener{itemClick(databean)}
            }
    }

    override fun getItemCount(): Int = dataList?.size ?: 0

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(itemLayoutId(), parent))
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun setViewHolder(dataBean: T){
            bindViewHolder(this,dataBean)
        }
    }

    abstract fun  itemLayoutId():Int

    abstract fun bindViewHolder(viewHolder: ViewHolder,dataBean: T)
}

