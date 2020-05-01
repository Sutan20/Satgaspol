package com.waynestudio.satgaspol.utils.function

import com.waynestudio.satgaspol.BahasaActivity
import com.waynestudio.satgaspol.FAQActivity
import com.waynestudio.satgaspol.PrivacyPolicyActivity
import com.waynestudio.satgaspol.ProfileActivity
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
    list.add(MenuItem("Profile", ProfileActivity::class.java))
    list.add(MenuItem("Bahasa", BahasaActivity::class.java))
    list.add("Bantuan")
    list.add(MenuItem("FAQ", FAQActivity::class.java))
    list.add(MenuItem("Live Chat", ProfileActivity::class.java))
    list.add("Info Privasi")
    list.add(MenuItem("Kebijakan Privasi", PrivacyPolicyActivity::class.java))
    return list
}