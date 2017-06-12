package com.jktaihe.kotlin.ui.fragment

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.jktaihe.engine.ui.BaseFragment
import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.bean.GankBean
import com.jktaihe.kotlin.net.OkHttpManeger
import com.jktaihe.kotlin.net.RxResultHelper
import com.jktaihe.kotlin.ui.adapter.GankAdapter
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_recommend.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

class RecommendFragment: BaseFragment(){

    var page = 1
    var mAdapter : GankAdapter? = null

    override fun layoutId(): Int {
        return R.layout.activity_recommend
    }

    override fun initView(savedInstanceState: Bundle?) {

        recycler_view.layoutManager = LinearLayoutManager(activity)

        val list = ArrayList<GankBean>()
        list.add(GankBean("id","","desc","","","","",false,""))
        list.add(GankBean("id","","desc","","","","",false,""))
        list.add(GankBean("id","","desc","","","","",false,""))
        list.add(GankBean("id","","desc","","","","",false,""))

        mAdapter = GankAdapter(list){
            dataBean ->
            toast(dataBean.desc.toString())
        }

        recycler_view.adapter = mAdapter

//        swipeRefreshLayout.setOnRefreshListener {
//            page = 1
//            getDatas()
//        }

//        getDatas()
    }

    fun getDatas(){

        Log.i("pageNum", "")
//        OkHttpManeger.getService()
//                .getList(page)
//                .subscribeOn(Schedulers.io())
//                .compose(RxResultHelper.handleResult())
//                .doOnTerminate { swipeRefreshLayout.isRefreshing = false }
//                .subscribe {
//                    resultBean ->
//                    mAdapter?.dataList = resultBean
//                    mAdapter?.notifyDataSetChanged()
//                    Log.i("pageNum", page.toString())
//                }
    }
}