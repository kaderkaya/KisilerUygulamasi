package com.kaderkayaarslan.kisileruygulamasi.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kaderkayaarslan.kisileruygulamasi.data.repo.KisilerDaoRepository

class KisiKayitViewModel : ViewModel(){
    val krepo = KisilerDaoRepository()

    fun kayit(kisi_ad: String,kisi_tel:String){
        krepo.kisiKayit("Kişi Kayıt","$kisi_ad - $kisi_tel")

    }
}