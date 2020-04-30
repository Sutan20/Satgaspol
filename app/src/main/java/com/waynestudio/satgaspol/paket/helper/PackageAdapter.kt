package com.waynestudio.satgaspol.paket.helper

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.waynestudio.satgaspol.R
import com.waynestudio.satgaspol.model.Barang
import kotlinx.android.synthetic.main.single_barang.view.*

class PackageAdapter(private var activity: Activity) : RecyclerView.Adapter<PackageAdapter.PackageViewHolder>(){
    val list : ArrayList<Barang> = arrayListOf()

    fun addBarang(barang : Barang){
        list.add(barang)
        notifyDataSetChanged()
    }

    fun addAll(list : ArrayList<Barang>){
        list.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.single_barang, parent, false)

        return PackageViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        holder.bindView(list[position])
    }

    inner class PackageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindView(barang : Barang){
            itemView.vPemilik.text = barang.pemilik
            itemView.vMasuk.text = barang.tanggal_masuk
            itemView.vEkspedisi.text = barang.ekspedisi
            itemView.vQty.text = "${barang.qty} Paket"
        }
    }
}