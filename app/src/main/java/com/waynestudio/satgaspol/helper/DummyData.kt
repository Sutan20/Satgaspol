package com.waynestudio.satgaspol.helper

import com.waynestudio.satgaspol.home.model.RT
import com.waynestudio.satgaspol.model.Barang
import com.waynestudio.satgaspol.more.model.MenuItem

fun generateRT() : ArrayList<RT>{
    val list = arrayListOf<RT>()
    for (i in 1..14){
        val barangList = arrayListOf<Barang>()
        for(j in 1..3){
            barangList.add(
                Barang(
                    j.toString(), "Test ${j.toString()}", "D2/59", "5", 1, "JNE", "", "2020-04-24", "Diterima"
                )
            )
        }
        list.add(
            RT(
                i.toString(),
                barangList
            )
        )
    }

    return list
}

fun generateBarang() : ArrayList<Barang>{
    val list = arrayListOf<Barang>()

    for (i in 1..14){
        list.add(
            Barang(
                i.toString(), "Test ${i.toString()}", "D2/59", "5", 1, "JNE", "", "2020-04-24", "Diterima"
            )
        )
    }

    return list
}

fun generateMenu() : ArrayList<Any>{
    val list = arrayListOf<Any>()
    list.add("Akun")
    list.add(MenuItem("Profile"))
    list.add(MenuItem("Bahasa"))
    list.add("Bantuan")
    list.add(MenuItem("FAQ"))
    list.add(MenuItem("Live Chat"))
    list.add("Info Privasi")
    list.add(MenuItem("Kebijakan Privasi"))
    return list
}