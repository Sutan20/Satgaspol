package com.waynestudio.satgaspol.home.helper

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.helper.debug
import com.waynestudio.satgaspol.home.model.RT
import kotlinx.android.synthetic.main.single_rekap_rt.view.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class HomeRekapAdapter(private var activity : Activity) : RecyclerView.Adapter<HomeRekapAdapter.RekapViewHolder>() {
    private var list : ArrayList<RT> = arrayListOf()

    fun addRT(rt: RT){
        list.add(rt)
        notifyDataSetChanged()
    }

    fun addAll(list : ArrayList<RT>){
        list.addAll(list)
        debug(this.javaClass.simpleName, "Add All Running Size:${list.size}")
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RekapViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_rekap_rt, parent, false)
        debug(this.javaClass.simpleName, "onCreateViewHolder Running")
        return RekapViewHolder(view)
    }

    override fun getItemCount(): Int {
        debug(this.javaClass.simpleName, "getItemCount Size:${list.size}")
        return list.size
    }

    override fun onBindViewHolder(holder: RekapViewHolder, position: Int) {
        holder.bindView(list[position])
        debug(
            this.javaClass.name,
            "Bind Running ${list.size}"
        )
    }

    inner class RekapViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(rt : RT){
            itemView.text_rt.text = "RT ${rt.rt}"
            itemView.tanggal_rt.text = "21 April 2020"
            itemView.total_rt.text = "${rt.barangList.size} Paket"
        }
    }
}