package com.lazyian.app

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Ian on 2023/12/29
 * Email: yixin0212@qq.com
 * Function :
 */
class MainViewModel:ViewModel() {
    var testList :MutableList<String> = arrayListOf("1","2","3","4","5")


    var adapterData = MutableLiveData<MutableList<String>>()
}