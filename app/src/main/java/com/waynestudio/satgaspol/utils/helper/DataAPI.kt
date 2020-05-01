package com.waynestudio.satgaspol.utils.helper

import com.waynestudio.satgaspol.model.Barang
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataAPI(var dbAPI : IDbAPI) {
    companion object {
        private const val BASE_URL = "http://dubin.tintamerdeka.co.id/api_dubin/processor/client/"
        private const val LANGUAGE_EN = "en-US"

        private var instance: DataAPI? = null

        fun repository(): DataAPI {
            if (instance == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                instance =
                    DataAPI(retrofit.create(IDbAPI::class.java))
            }

            return instance as DataAPI
        }
    }

    suspend fun getAllBarang(s : String) = dbAPI.getByBlock(s)
    suspend fun getBarangRT(s : String) = dbAPI.getByRT(s)
}