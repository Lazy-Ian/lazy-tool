package com.lazyian.tool.util

import android.util.Log


/**
 * Created by Ian on 2022/5/13
 * Email: yixin0212@qq.com
 * Function : 计时器
 */
object LauncherTimer {
    var startTime: Long = 0L

    fun logStart() {
        startTime = System.currentTimeMillis()
    }

    fun logEnd(tag: String) {
        Log.d("LauncherTimer", tag + "launcher time = " + (System.currentTimeMillis() - startTime))
    }

    fun cleanTime(){
        startTime = 0L
    }
}