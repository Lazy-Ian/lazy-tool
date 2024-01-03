package com.lazyian.tool.base

import java.lang.reflect.ParameterizedType


/**
 * Created by Ian on 2021/5/19
 * Email: yixin0212@qq.com
 * Function :取当前类绑定的泛型ViewModel-clazz
 */

@Suppress("UNCHECKED_CAST")
fun <VM> getVmClazz(obj: Any): VM {
    return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}

