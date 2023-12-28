package com.lazyian.tool.base.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lazyian.tool.databinding.ItemFooterViewBinding

/**
 * Created by Ian on 2023/12/20
 * Email: yixin0212@qq.com
 * Function : 为RecyclerView添加头部和底部
 */
abstract class HeaderFooterAdapter<T>(override var data: MutableList<T>) : BaseAdapter<T>(data) {
    var isCanLoadMore = false
    var isFooterShow = false

    constructor(manager: GridLayoutManager, data: MutableList<T>) : this(data) {
        manager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return when (getItemViewType(position)) {
                    TYPE_FOOTER -> 2
                    TYPE_HEADER -> 2
                    else -> 1
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_HEADER) {
            return onCreateHeaderViewHolder(parent, viewType)!!
        } else if (viewType == TYPE_FOOTER) {
            return onCreateFooterViewHolder(parent, viewType)
        }
        return onCreateContentViewHolder(parent, viewType - TYPE_ADAPTER_OFFSET)!!
    }


    override fun onBindViewHolder(@NonNull holder: RecyclerView.ViewHolder, position: Int) {
        if (position == 0 && holder.itemViewType == TYPE_HEADER) {
            onBindHeaderView(holder, position)
        } else if (position == getItemContentCount() + (if (useHeader()) 1 else 0) && holder.itemViewType == TYPE_FOOTER) {
            onBindFooterView(holder, position)
        } else {
            onBindContentView(holder, position - if (useHeader()) 1 else 0)
        }
    }


    override fun getItemCount(): Int {
        var itemCount = getItemContentCount()
        if (useHeader()) {
            itemCount += 1
        }
        if (useFooter()) {
            itemCount += 1
        }
        return itemCount

    }


    override fun getItemViewType(position: Int): Int {
        if (position == 0 && useHeader()) {
            return TYPE_HEADER
        }
        if (position == getItemContentCount() + (if (useHeader()) 1 else 0) && useFooter()) {
            return TYPE_FOOTER
        }
        if (getContentItemType(position) >= Int.MAX_VALUE - TYPE_ADAPTER_OFFSET) {
            IllegalStateException("HeaderRecyclerViewAdapter offsets your BasicItemType by $TYPE_ADAPTER_OFFSET.")
        }
        return getContentItemType(position) + TYPE_ADAPTER_OFFSET
    }

    open fun useHeader(): Boolean {
        return false
    }

    open fun onCreateHeaderViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        return null
    }

    open fun onBindHeaderView(holder: RecyclerView.ViewHolder, position: Int) {}


    open fun useFooter(): Boolean {
        return false
    }

    open fun onCreateFooterViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val footerBinding = ItemFooterViewBinding.inflate(LayoutInflater.from(parent.context))
        return BaseViewHolder(parent.context, footerBinding)
    }

    open fun onBindFooterView(holder: RecyclerView.ViewHolder, position: Int) {
        val footerBinding = (holder as BaseViewHolder<ItemFooterViewBinding>).binding
        if (isCanLoadMore) {
            footerBinding.footerTitle.text = "加载更多..."
        } else {
            footerBinding.footerTitle.text = "我是有底线的"
        }
    }

    abstract fun onCreateContentViewHolder(
        parent: ViewGroup?,
        viewType: Int
    ): RecyclerView.ViewHolder?

    abstract fun onBindContentView(holder: RecyclerView.ViewHolder?, position: Int)

    abstract fun getItemContentCount(): Int

    abstract fun getContentItemType(position: Int): Int

    override fun notifyDataChange() {
        super.notifyDataChange()
        isFooterShow = false
    }

    companion object {
        private const val TYPE_HEADER = Int.MIN_VALUE
        private const val TYPE_FOOTER = Int.MIN_VALUE + 1
        private const val TYPE_ADAPTER_OFFSET = 2
    }
}
