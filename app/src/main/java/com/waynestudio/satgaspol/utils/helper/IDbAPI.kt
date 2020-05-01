package com.waynestudio.satgaspol.utils.helper

import com.waynestudio.satgaspol.home.model.RT
import com.waynestudio.satgaspol.model.Barang
import com.waynestudio.satgaspol.model.ResponseAPI
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IDbAPI {
    @GET("findByBlok.php")
    suspend fun getByBlock(
        @Query("s") block : String
    ) : ResponseAPI<Barang>

    @GET("findByRt.php")
    suspend fun getByRT(
        @Query("rt") rt : String
    ) : ResponseAPI<RT>
}