package com.waynestudio.satgaspol.data.source.remote

import android.os.Handler
import com.waynestudio.satgaspol.home.model.RT
import com.waynestudio.satgaspol.model.Barang
import com.waynestudio.satgaspol.utils.helper.DataAPI
import kotlinx.coroutines.flow.*

class RemoteRepository(private var dataAPI: DataAPI) {
    companion object {
        var SERVICE_LATENCY_IN_MILLIS: Long = 5000

        private var instance: RemoteRepository? = null
        fun instance(helper: DataAPI): RemoteRepository {
            if (instance == null) {
                instance =
                    RemoteRepository(helper)
            }

            return instance as RemoteRepository
        }
    }

    fun allItems(s : String) : Flow<Barang> = flow {
        dataAPI.getAllBarang(s).list.asFlow().collect {
            emit(it)
        }
    }

    fun itemRT(s : String) : Flow<RT> = flow {
        dataAPI.getBarangRT(s).list.asFlow().collect {
            emit(it)
        }
    }
}