package com.waynestudio.satgaspol.model

import com.google.gson.annotations.SerializedName

data class ResponseAPI<T>(
    @SerializedName("total") val total: Int,
    @SerializedName("records") val list: ArrayList<T>
)