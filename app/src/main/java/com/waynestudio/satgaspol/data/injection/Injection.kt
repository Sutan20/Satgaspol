package com.waynestudio.satgaspol.data.injection

import com.waynestudio.satgaspol.data.source.BarangRepository
import com.waynestudio.satgaspol.data.source.remote.RemoteRepository
import com.waynestudio.satgaspol.utils.helper.DataAPI

class Injection {
    companion object {
        fun provideBarangRepository(): BarangRepository {
            val remoteRepository: RemoteRepository = RemoteRepository.instance(DataAPI.repository())

            return BarangRepository.getInstance(remoteRepository)
        }
    }
}