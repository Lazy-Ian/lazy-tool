package com.lazyian.tool.ext.ext

import android.util.Log


/**
 * Created by Ian on 2021/5/19
 * Email: yixin0212@qq.com
 * Function :
 */

const val TAG = "lib-tool"

/**
 *
 * 是否需要开启打印日志，默认关闭，关闭后会没有网络请求日志和该框架产生的打印
  */
var okHttpLog = false

private enum class LEVEL {
    V, D, I, W, E
}

fun String.logv(tag: String = TAG) =
    log(LEVEL.V, tag, this)

fun String.logd(tag: String = TAG) =
    log(LEVEL.D, tag, this)

fun String.logi(tag: String = TAG) =
    log(LEVEL.I, tag, this)

fun String.logw(tag: String = TAG) =
    log(LEVEL.W, tag, this)

fun String.loge(tag: String = TAG) =
    log(LEVEL.E, tag, this)

private fun log(level: LEVEL, tag: String, message: String) {
    if (!okHttpLog) return
    when (level) {
        LEVEL.V -> Log.v(tag, message)
        LEVEL.D -> Log.d(tag, message)
        LEVEL.I -> Log.i(tag, message)
        LEVEL.W -> Log.w(tag, message)
        LEVEL.E -> Log.e(tag, message)
    }
}