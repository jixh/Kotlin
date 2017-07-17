package com.jktaihe.kotlin.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.jktaihe.kotlin.ui.fragment.recommend.RecommendFragment

/**
 * Created by hzjixiaohui on 2017-6-14.
 */
class FragmentAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    var tabTitles :List<String>? = null

    override fun getItem(p0: Int): Fragment {
       return RecommendFragment.getInstance(p0)
    }

    override fun getCount(): Int {
        return tabTitles?.size?:0
    }

    fun getTitle(position:Int):String{
        return tabTitles?.get(position) ?:""
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles?.get(position)?:""
    }

}