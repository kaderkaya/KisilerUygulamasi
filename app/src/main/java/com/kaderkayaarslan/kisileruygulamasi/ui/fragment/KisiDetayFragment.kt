package com.kaderkayaarslan.kisileruygulamasi.ui.fragment

import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.kaderkayaarslan.kisileruygulamasi.R
import com.kaderkayaarslan.kisileruygulamasi.databinding.FragmentKisiDetayBinding


class KisiDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentKisiDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim =DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)
        tasarim.kisiDetayFragment = this
        tasarim.kisiDetaytToolbarBaslik = "Kişi Detay"

        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        tasarim.kisiNesnesi = gelenKisi

        return tasarim.root
    }
    fun buttonGuncelle(kisi_id:Int, kisi_ad: String,kisi_tel:String){
        Log.e("Kişi Güncelle"," $kisi_id - $kisi_ad - $kisi_tel")

    }


}