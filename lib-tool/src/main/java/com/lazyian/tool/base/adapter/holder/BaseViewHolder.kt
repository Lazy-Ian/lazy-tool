package com.lazyian.tool.base.adapter.holder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Created by Ian on 2023/11/29
 * Email: yixin0212@qq.com
 * Function : BaseViewHolder
 */
class BaseViewHolder<V : ViewBinding>(val context: Context, val binding: V) : RecyclerView.ViewHolder(binding.root) {
}