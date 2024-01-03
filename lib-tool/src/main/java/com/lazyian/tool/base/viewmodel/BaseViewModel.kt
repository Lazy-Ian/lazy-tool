package com.lazyian.tool.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lazyian.tool.callback.livedata.event.EventLiveData


/**
 * Created by Ian on 2021/5/19
 * Email: yixin0212@qq.com
 * Function :
 * Function :ViewModel的基类 使用ViewModel类，放弃AndroidViewModel，原因：用处不大 完全有其他方式获取Application上下文
 */
open class BaseViewModel : ViewModel() {


    //页码  1开始
    var pageIndex = 1
    var submitBtn :Boolean = false

    /**基础返回值*/
//    var resultResult = MutableLiveData<ResultState<ResultInfo>>()

    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }


    /**
     * 内置封装好的可通知Activity/fragment 显示隐藏加载框
     */
    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { EventLiveData<String>() }

        //隐藏
        val dismissDialog by lazy { EventLiveData<Boolean>() }
    }

}