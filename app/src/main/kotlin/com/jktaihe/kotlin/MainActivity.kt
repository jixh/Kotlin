package com.jktaihe.kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView
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

        disableShiftMode(navigation)

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

    @SuppressLint("RestrictedApi")
    fun disableShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
            shiftingMode.isAccessible = true
            shiftingMode.setBoolean(menuView, false)
            shiftingMode.isAccessible = false
            for (i in 0..menuView.childCount - 1) {
                val item = menuView.getChildAt(i) as BottomNavigationItemView
                item.setShiftingMode(false)
                item.setChecked(item.itemData.isChecked)
            }
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }

    }

}

