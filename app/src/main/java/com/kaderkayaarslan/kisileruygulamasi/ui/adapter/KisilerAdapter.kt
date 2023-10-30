package com.kaderkayaarslan.kisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.kaderkayaarslan.kisileruygulamasi.R
import com.kaderkayaarslan.kisileruygulamasi.data.entity.Kişiler
import com.kaderkayaarslan.kisileruygulamasi.databinding.CardTasarimBinding
import com.kaderkayaarslan.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.kaderkayaarslan.kisileruygulamasi.ui.fragment.AnasayfaFragment
import com.kaderkayaarslan.kisileruygulamasi.ui.fragment.AnasayfaFragmentDirections
import com.kaderkayaarslan.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.kaderkayaarslan.kisileruygulamasi.util.gecisYap

class KisilerAdapter(var mContext: Context,
                     var kisilerListesi:List<Kişiler>,
                     var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim:CardTasarimBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
       val layoutInflater = LayoutInflater.from(mContext)
       val tasarim:CardTasarimBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim, parent, false)
        return CardTasarimTutucu(tasarim)



    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position)
       val t = holder.tasarim
        t.kisiNesnesi = kisi
        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.gecisYap(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?", Snackbar.LENGTH_LONG)
                .setAction("EVET"){
                   viewModel.sil(kisi.kisi_id)
                }.show()

        }
    }

    override fun getItemCount(): Int {
     return kisilerListesi.size
    }
}