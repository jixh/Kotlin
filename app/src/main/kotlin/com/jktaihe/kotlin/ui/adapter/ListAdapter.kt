package com.jktaihe.kotlin.ui.adapter

import com.jktaihe.kotlin.extensions.ctx

/**
 * Created by hzjixiaohui on 2017-6-1.
 */

class ListAdapter(val weekForecast: com.jktaihe.kotlin.domain.ForecastList, val itemClick: (com.jktaihe.kotlin.domain.Forecast) -> Unit) : android.support.v7.widget.RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    override fun onBindViewHolder(viewHolder: com.jktaihe.kotlin.ui.adapter.ListAdapter.ViewHolder, position: Int) {
        viewHolder.bindForecaset(weekForecast.dailyForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onCreateViewHolder(parent: android.view.ViewGroup, p1: Int): com.jktaihe.kotlin.ui.adapter.ListAdapter.ViewHolder {
        val tv = android.widget.TextView(parent.ctx)
        tv.text = "this is test"
        return com.jktaihe.kotlin.ui.adapter.ListAdapter.ViewHolder(tv, itemClick)
    }

    class ViewHolder(view: android.widget.TextView, val itemClick: (com.jktaihe.kotlin.domain.Forecast) -> Unit) : android.support.v7.widget.RecyclerView.ViewHolder(view) {
        fun bindForecaset(forecast: com.jktaihe.kotlin.domain.Forecast) {
            with(forecast) {
                //               itemView.to = "$date - $description - $high /$low"
                itemView.setOnClickListener {
                    itemClick(this)
                }
            }
        }
    }
}

