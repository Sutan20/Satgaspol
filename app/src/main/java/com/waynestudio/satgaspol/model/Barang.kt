package com.waynestudio.satgaspol.model

import com.google.gson.annotations.SerializedName


data class Barang (
    @SerializedName("id")
    var id : String,
    @SerializedName("pemilik")
    var pemilik : String,
    @SerializedName("no_rumah")
    var no_rumah : String,
    @SerializedName("no_rt")
    var no_rt : String,
    @SerializedName("qty")
    var qty : Int,
    @SerializedName("ekspedisi")
    var ekspedisi : String,
    @SerializedName("tanggal_keluar")
    var tanggal_keluar : String,
    @SerializedName("tanggal_masuk")
    var tanggal_masuk : String,
    @SerializedName("status")
    var status : String
)