package com.jktaihe.engine.ui

import android.app.AlertDialog
import com.jktaihe.engine.utils.getDefaultDialog

/**
 * Created by hzjixiaohui on 2017-6-7.
 */

abstract class BaseLoadDialogFragment : BaseFragment() ,LoadDialog{

    var loddingDialog:AlertDialog? = null

    override fun show() {
        if (loddingDialog == null){
            loddingDialog = getDefaultDialog("正在加载...").show()
        } else if (!loddingDialog?.isShowing!!){
            loddingDialog?.show()
        }
    }

    override fun hide() {
        loddingDialog.let {
            if (loddingDialog!!.isShowing)
                loddingDialog!!.dismiss()
        }
    }
}
