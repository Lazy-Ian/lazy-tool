package com.lazyian.tool.callback.livedata

import androidx.lifecycle.MutableLiveData


/**
 * Created by Ian on 2021/5/19
 * Email: yixin0212@qq.com
 * Function :自定义的Boolean类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
class IntLiveData : MutableLiveData<Int>() {

    override fun getValue(): Int {
        return super.getValue() ?: 0
    }
}