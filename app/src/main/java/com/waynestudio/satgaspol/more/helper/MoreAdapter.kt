package com.waynestudio.satgaspol.more.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.more.model.MenuItem
import kotlinx.android.synthetic.main.menu_item_content.view.*
import kotlinx.android.synthetic.main.menu_item_header.view.*

class MoreAdapter(private val data: List<Any>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val ITEM_HEADER = 0
        private const val ITEM_MENU = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (data[position]) {
            is String -> ITEM_HEADER
            is MenuItem -> ITEM_MENU
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_HEADER -> MoreHeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item_header, parent, false))
            ITEM_MENU -> MoreContentViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item_content, parent, false))
            else -> throw throw IllegalArgumentException("Undefined view type")
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder.itemViewType) {
            ITEM_HEADER -> {
                val headerHolder = holder as MoreHeaderViewHolder
                headerHolder.bindView(data[position] as String)
            }
            ITEM_MENU -> {
                val itemHolder = holder as MoreContentViewHolder
                if (position == data.lastIndex || data[position + 1] is String){
                    itemHolder.bindView(data[position] as MenuItem)
                } else {
                    itemHolder.bindView(data[position] as MenuItem, false)
                }
            }
            else -> throw IllegalArgumentException("Undefined view type")
        }
    }

    inner class MoreHeaderViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(s : String){
            itemView.headerMenu.text = s
        }
    }

    inner class MoreContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindView(m : MenuItem, next : Boolean = true){
            itemView.contentMenu.text = m.name

            if(next){
                itemView.content_layout.setBackgroundResource(android.R.color.transparent)
                itemView.main_content_layout.background = itemView.resources.getDrawable(R.drawable.white_bottom_grey)
            }
        }
    }
}