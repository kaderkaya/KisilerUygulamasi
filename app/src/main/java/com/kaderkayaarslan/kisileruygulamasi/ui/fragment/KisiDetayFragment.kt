package com.kaderkayaarslan.kisileruygulamasi.ui.fragment

import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.kaderkayaarslan.kisileruygulamasi.R
import com.kaderkayaarslan.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.kaderkayaarslan.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.kaderkayaarslan.kisileruygulamasi.ui.viewmodel.KisiDetayViewModel
import com.kaderkayaarslan.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel


class KisiDetayFragment : Fragment() {
    private lateinit var tasarim:FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim =DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay, container, false)
        tasarim.kisiDetayFragment = this
        tasarim.kisiDetaytToolbarBaslik = "Kişi Detay"

        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi

        tasarim.kisiNesnesi = gelenKisi

        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiDetayViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun buttonGuncelle(kisi_id:Int, kisi_ad: String,kisi_tel:String){
          viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)
    }

}