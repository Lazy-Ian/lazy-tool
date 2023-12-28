package com.lazyian.tool.base.adapter

import android.view.View

/**
 * Created by Ian on 2023/11/29
 * Email: yixin0212@qq.com
 * Function : BaseBindAdapter 点击监听事件
 */
interface OnItemClickListener {
    fun onItemClick(view: View, position: Int)

}