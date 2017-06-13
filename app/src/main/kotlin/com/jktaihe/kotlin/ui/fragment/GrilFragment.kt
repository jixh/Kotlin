package com.jktaihe.kotlin.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.jktaihe.engine.ui.BaseFragment
import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.bean.GankBean
import com.jktaihe.kotlin.net.OkHttpManeger
import com.jktaihe.kotlin.net.RxResultHelper
import com.jktaihe.kotlin.ui.adapter.GirlAdapter
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_girl.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

class GirlFragment: BaseFragment(){
    var page = 1
    lateinit var mAdapter : GirlAdapter

    override fun layoutId(): Int {
        return R.layout.activity_girl
    }

    override fun initView(savedInstanceState: Bundle?) {

        rv_list.layoutManager = LinearLayoutManager(activity)
//
        val list = ArrayList<GankBean>()
//
        mAdapter = GirlAdapter(list){
            dataBean ->
            toast(dataBean.desc.toString())
        }

        rv_list.adapter = mAdapter

        swipeRefreshLayout.setOnRefreshListener {
            page = 1
            getDatas()
        }

        getDatas()
    }

    private fun getDatas() {
        OkHttpManeger.getService()
                .get福利(page)
                .subscribeOn(Schedulers.io())
                .compose(RxResultHelper.handleResult())
                .doOnTerminate { swipeRefreshLayout.isRefreshing = false }
                .subscribe {
                    resultBean ->
                    mAdapter.dataList = resultBean
                    mAdapter.notifyDataSetChanged()
                }
    }


}