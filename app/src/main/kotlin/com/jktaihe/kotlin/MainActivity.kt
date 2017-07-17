package com.jktaihe.kotlin

import android.os.Bundle
import android.support.v4.app.Fragment
import com.jktaihe.engine.ui.BaseActivity
import com.jktaihe.engine.ui.InstanceView.Companion.createInstance
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by hzjixiaohui on 2017-6-1.
 */

class MainActivity : BaseActivity(){

    val tabs = Tab.values()
    var lastPostion:Int = tabs.size

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView(savedInstanceState)
    }

     fun initView(savedInstanceState: Bundle?) {
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_recommend -> {
                    changeTab(0)
                }
                R.id.action_girl -> {
                    changeTab(1)
                }
                R.id.action_history -> {
                    changeTab(2)
                }
            }
            true
        }

        changeTab(0)
    }

    private fun changeTab(i: Int) {

        if (i == lastPostion) return else lastPostion = i

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        var currentTab = supportFragmentManager.findFragmentByTag(tabs[i].name)

        if (currentTab == null){
            currentTab = createInstance(tabs[i].clz) as Fragment
            fragmentTransaction.replace(R.id.container,currentTab,tabs[i].name)
        }else{
            fragmentTransaction.show(currentTab)
        }

        fragmentTransaction.commitAllowingStateLoss()

    }
}

