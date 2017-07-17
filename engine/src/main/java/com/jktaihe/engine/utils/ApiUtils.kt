package com.jktaihe.engine.utils

import android.os.Build


/**
 * Created by hzjixiaohui on 2017-6-13.
 */

inline fun supportApi21(api21:() -> Unit,api21s:() -> Unit){
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)api21()else api21s()
}


