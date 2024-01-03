package com.lazyian.tool.callback.livedata

import androidx.lifecycle.MutableLiveData


/**
 * Created by Ian on 2021/5/19
 * Email: yixin0212@qq.com
 * Function :自定义的Short类型 MutableLiveData 提供了默认值，避免取值的时候还要判空
 */
class ShortLiveData : MutableLiveData<Short>() {
    override fun getValue(): Short {
        return super.getValue() ?: 0
    }
}