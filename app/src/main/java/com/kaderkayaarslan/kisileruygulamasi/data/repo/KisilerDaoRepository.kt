package com.kaderkayaarslan.kisileruygulamasi.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kaderkayaarslan.kisileruygulamasi.data.entity.Kişiler

class KisilerDaoRepository {
    var kisilerListesi:MutableLiveData<List<Kişiler>>
    init {
        kisilerListesi = MutableLiveData()
    }
    fun kisileriGetir() : MutableLiveData<List<Kişiler>>{
        return kisilerListesi
    }

    fun kisiKayit(kisi_ad: String,kisi_tel:String){
        Log.e("Kişi Kayıt","$kisi_ad - $kisi_tel")

    }
    fun kisiGuncelle(kisi_id:Int, kisi_ad: String,kisi_tel:String){
        Log.e("Kişi Güncelle"," $kisi_id - $kisi_ad - $kisi_tel")

    }
    fun kisiAra(aramaKelimesi:String){
        Log.e("Kişi Ara",aramaKelimesi)

    }
    fun kisiSil(kisi_id: Int){
        Log.e("Kişi Sil",kisi_id.toString())

    }
    fun tumKisileriAl(){
        val liste = ArrayList<Kişiler>()
        val k1 = Kişiler(1,"Ahmet","1111")
        val k2 = Kişiler(2,"Zeynep","2222")
        val k3 = Kişiler(3,"Beyza","3333")
        liste.add(k1)
        liste.add(k2)
        liste.add(k3)
        kisilerListesi.value = liste

    }
}