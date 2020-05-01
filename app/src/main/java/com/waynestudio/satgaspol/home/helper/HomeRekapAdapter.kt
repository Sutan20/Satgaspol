package com.waynestudio.satgaspol.home.helper

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.utils.function.debug
import com.waynestudio.satgaspol.home.model.RT
import kotlinx.android.synthetic.main.single_rekap_rt.view.*
import kotlin.collections.ArrayList

class HomeRekapAdapter(private var activity : Activity) : RecyclerView.Adapter<HomeRekapAdapter.RekapViewHolder>() {
    private var list : ArrayList<RT> = arrayListOf()

    fun addRT(rt: RT){
        list.add(rt)
        notifyDataSetChanged()
    }

    fun addAll(list : ArrayList<RT>){
        list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RekapViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_rekap_rt, parent, false)
        return RekapViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RekapViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    inner class RekapViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(rt : RT){
            itemView.text_rt.text = "RT ${rt.rt}"
            itemView.tanggal_rt.text = "21 April 2020"
            itemView.total_rt.text = "${rt.barangList.size} Paket"
        }
    }
}