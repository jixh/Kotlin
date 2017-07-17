package com.jktaihe.engine.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.jktaihe.engine.ui.BaseLoadDialogFragment


/**
 * Created by hzjixiaohui on 2017-6-13.
 */


fun BaseLoadDialogFragment.getDefaultDialog(message: String): AlertDialog.Builder {
    val adb = AlertDialog.Builder(this.context)
    adb.setMessage(message)
    return adb
}

fun BaseLoadDialogFragment.getDialog(message: String,
                                     neutralText: String,
                                     neutralClickListener: DialogInterface.OnClickListener,
                                     positiveText: String,
                                     positiveClickListener: DialogInterface.OnClickListener ): AlertDialog.Builder {

    val adb = getDefaultDialog(message)

    supportApi21({
        adb.setNeutralButton(neutralText, neutralClickListener)
    }, {
        adb.setNegativeButton(neutralText, neutralClickListener)
    })

    adb.setPositiveButton(positiveText, positiveClickListener)

    return adb
}





