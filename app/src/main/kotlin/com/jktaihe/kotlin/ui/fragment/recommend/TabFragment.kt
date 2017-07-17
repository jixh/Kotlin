package com.jktaihe.kotlin.ui.fragment.recommend

import android.os.Bundle
import com.jktaihe.engine.ui.BaseFragment
import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.net.OkHttpManeger
import com.jktaihe.kotlin.net.RxResultHelper
import com.jktaihe.kotlin.ui.adapter.FragmentAdapter
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_recommend.*
import kotlinx.android.synthetic.main.activity_tabs.*

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

class TabFragment: BaseFragment(){

    lateinit var mAdapter : FragmentAdapter

    override fun layoutId(): Int {
        return R.layout.activity_tabs
    }

    override fun initView(savedInstanceState: Bundle?) {

        val list = listOf("all","Android","IOS")

        mAdapter = FragmentAdapter(childFragmentManager)
        mAdapter.tabTitles = list

        vp_content.adapter = mAdapter
        tl_tabs.setupWithViewPager(vp_content)

    }

    fun getDatas(){
        OkHttpManeger.getService()
                .getList(1)
                .subscribeOn(Schedulers.io())
                .compose(RxResultHelper.handleResult())
                .doOnSubscribe {
                }
                .doOnTerminate {
                    swipeRefreshLayout.isRefreshing = false }
                .subscribe {
                    resultBean ->
                }
    }

}