package com.waynestudio.satgaspol.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.waynestudio.satgaspol.data.source.remote.RemoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class BarangRepository(var remoteRepository: RemoteRepository) {
    companion object {
        @Volatile
        private var instance: BarangRepository? = null

        fun getInstance(remoteRepository: RemoteRepository): BarangRepository {
            if (instance == null) {
                synchronized(BarangRepository::class.java) {
                    if (instance == null) {
                        instance =
                            BarangRepository(
                                remoteRepository
                            )
                    }
                }
            }

            return instance as BarangRepository
        }
    }

    fun allBarang(s : String) = remoteRepository.allItems(s)
    fun barangRT(s : String) = remoteRepository.itemRT(s)
}