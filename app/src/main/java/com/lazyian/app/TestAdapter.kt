package com.lazyian.app

import android.view.LayoutInflater
import android.view.ViewGroup
import com.lazyian.app.databinding.ItemBaseBindBinding
import com.lazyian.tool.base.adapter.BaseBindAdapter
import com.lazyian.tool.base.adapter.BaseViewHolder

/**
 * Created by Ian on 2023/12/28
 * Email: yixin0212@qq.com
 * Function : baseBindAdapter  使用
 */
class TestAdapter(data: MutableList<String>) : BaseBindAdapter<String, ItemBaseBindBinding>(data) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemBaseBindBinding> {

        return BaseViewHolder(
            parent.context,
            ItemBaseBindBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: BaseViewHolder<ItemBaseBindBinding>,
        position: Int,
        binding: ItemBaseBindBinding,
        item: String
    ) {
        binding.tvTitle.text = item
        holder.itemView.setOnClickListener {
            if (onItemClickListener != null) {
                onItemClickListener!!.onItemClick(it, position)
            }
        }

    }

}