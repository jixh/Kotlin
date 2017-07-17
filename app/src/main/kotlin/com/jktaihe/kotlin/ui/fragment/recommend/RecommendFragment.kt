package com.jktaihe.kotlin.ui.fragment.recommend

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jktaihe.engine.ui.BaseFragment
import com.jktaihe.kotlin.R
import com.jktaihe.kotlin.net.OkHttpManeger
import com.jktaihe.kotlin.net.RxResultHelper
import com.jktaihe.kotlin.ui.adapter.GankAdapter
import com.jktaihe.kotlin.ui.decoration.JKItemDecoration
import com.zhy.adapter.recyclerview.DividerItemDecoration
import com.zhy.adapter.recyclerview.wrapper.LoadMoreWrapper
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_recommend.*
import org.jetbrains.anko.support.v4.toast

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

class RecommendFragment: BaseFragment(){

    var page = 1
    lateinit var mAdapter : GankAdapter
    lateinit var mMoreAdapter : LoadMoreWrapper
    var position:Int = -1

    override fun layoutId(): Int {
        return R.layout.activity_recommend
    }

    override fun initView(savedInstanceState: Bundle?) {

        position = arguments?.getInt("position")?:0

        mAdapter = GankAdapter{
                    dataBean ->
                    DetailActivity.startActivity(context,dataBean.url)
                }

        mMoreAdapter = LoadMoreWrapper(mAdapter)
        mMoreAdapter.setLoadMoreView(R.layout.layout_loadmore)
        mMoreAdapter.setOnLoadMoreListener {
                page++
                getDatas()
        }
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = mMoreAdapter
        recycler_view.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL_LIST))
        swipeRefreshLayout.setOnRefreshListener {
            page = 1
            getDatas()
        }

        getDatas()

    }

    fun getDatas(){
        OkHttpManeger.getService()
                .getList(page)
                .subscribeOn(Schedulers.io())
                .compose(RxResultHelper.handleResult())
                .doOnTerminate {
                    swipeRefreshLayout.isRefreshing = false
                }
                .subscribe {
                    resultBean ->

                    mMoreAdapter.isHasMore = !resultBean.isEmpty()

                    if (page == 1){
                        mAdapter.dataList?.clear()
                    }
                    mAdapter.dataList?.addAll(resultBean)
                    mMoreAdapter.notifyDataSetChanged()
                }
    }

    companion object{
        fun getInstance(position:Int): RecommendFragment {
            val recommendFragemnt  = RecommendFragment()
            val args = Bundle()
            args.putInt("position",position)
            recommendFragemnt.arguments = args
            return recommendFragemnt
        }
    }
}