package com.waynestudio.satgaspol.utils.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.waynestudio.satgaspol.data.injection.Injection
import com.waynestudio.satgaspol.data.source.BarangRepository
import com.waynestudio.satgaspol.home.helper.HomeViewModel


class BarangViewModelFactory(var barangRepository: BarangRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        private var instance: BarangViewModelFactory? = null
        fun getInstance(): BarangViewModelFactory {
            if (instance == null) {
                synchronized(BarangViewModelFactory::class.java) {
                    if (instance == null) {
                        instance = BarangViewModelFactory(Injection.provideBarangRepository())
                    }
                }
            }

            return instance as BarangViewModelFactory
        }
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(barangRepository) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass::class.java.simpleName)
    }
}