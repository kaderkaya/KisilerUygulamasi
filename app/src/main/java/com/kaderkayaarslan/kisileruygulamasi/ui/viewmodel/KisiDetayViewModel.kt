package com.kaderkayaarslan.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kaderkayaarslan.kisileruygulamasi.data.repo.KisilerDaoRepository

class KisiDetayViewModel : ViewModel() {
    val krepo = KisilerDaoRepository()

    fun guncelle(kisi_id:Int, kisi_ad: String,kisi_tel:String){
        krepo.kisiGuncelle(kisi_id,kisi_ad,kisi_tel)
    }
}