package com.lazyian.tool.ext.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import com.lazyian.tool.callback.livedata.BooleanLiveData
import com.lazyian.tool.util.LogUtils


/**
 * Created by Ian on 2021/5/19
 * Email: yixin0212@qq.com
 * Function :
 */

object KtxAppLifeObserver : LifecycleEventObserver {

    var isForeground = BooleanLiveData()


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (event == Lifecycle.Event.ON_START) {
            //在前台  instead.
            isForeground.value = true
            LogUtils.debugInfo("KtxAppLifeObserver", "在前台---")
        } else if (event == Lifecycle.Event.ON_START) {
            //在后台
            isForeground.value = false
            LogUtils.debugInfo("KtxAppLifeObserver", "在后台---")

        }

    }

}