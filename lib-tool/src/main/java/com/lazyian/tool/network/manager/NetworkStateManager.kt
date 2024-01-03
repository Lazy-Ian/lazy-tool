package com.lazyian.tool.network.manager

import com.lazyian.tool.callback.livedata.UnPeekLiveData


/**
 * Created by Ian on 2021/5/19
 * Email: yixin0212@qq.com
 * Function :网络变化管理者
 */
class NetworkStateManager  private constructor() {

    val mNetworkStateCallback = UnPeekLiveData<NetState>()

    companion object {
        val instance: NetworkStateManager by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            NetworkStateManager()
        }
    }

}