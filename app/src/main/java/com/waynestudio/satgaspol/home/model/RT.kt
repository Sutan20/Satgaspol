package com.waynestudio.satgaspol.home.model

import com.google.gson.annotations.SerializedName
import com.waynestudio.satgaspol.model.Barang

data class RT (
    var rt : String,
    @SerializedName("records")
    var barangList : ArrayList<Barang>
)