package com.waynestudio.satgaspol.home.helper

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.waynestudio.satgaspol.data.source.BarangRepository
import com.waynestudio.satgaspol.home.model.RT
import com.waynestudio.satgaspol.model.Barang
import kotlinx.coroutines.flow.collect

class HomeViewModel(private var repository: BarangRepository) : ViewModel(){
    fun items(s : String) : LiveData<Barang> = liveData {
        repository.allBarang(s).collect {
            emit(it)
        }
    }

    fun rt(s : String) : LiveData<RT> = liveData {
        repository.barangRT(s).collect{
            emit(it)
        }
    }
}