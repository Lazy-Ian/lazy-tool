package com.lazyian.tool.network.manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.lazyian.tool.network.NetworkUtil


/**
 * Created by Ian on 2021/5/19
 * Email: yixin0212@qq.com
 * Function :网络变化接收器
 */
class NetworkStateReceive : BroadcastReceiver() {
    var isInit = true
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == ConnectivityManager.CONNECTIVITY_ACTION) {
            if(!isInit){
                if (!NetworkUtil.isNetworkAvailable(context)) {
                    //收到没有网络时判断之前的值是不是有网络，如果有网络才提示通知 ，防止重复通知
                    NetworkStateManager.instance.mNetworkStateCallback.value?.let {
                        if(it.isSuccess){
                            //没网
                            NetworkStateManager.instance.mNetworkStateCallback.postValue(NetState(isSuccess = false))
                        }
                        return
                    }
                    NetworkStateManager.instance.mNetworkStateCallback.postValue(NetState(isSuccess = false))
                }else{
                    //收到有网络时判断之前的值是不是没有网络，如果没有网络才提示通知 ，防止重复通知
                    NetworkStateManager.instance.mNetworkStateCallback.value?.let {
                        if(!it.isSuccess){
                            //有网络了
                            NetworkStateManager.instance.mNetworkStateCallback.postValue(NetState(isSuccess = true))
                        }
                        return
                    }
                    NetworkStateManager.instance.mNetworkStateCallback.postValue(NetState(isSuccess = true))
                }
            }
            isInit = false
        }
    }
}