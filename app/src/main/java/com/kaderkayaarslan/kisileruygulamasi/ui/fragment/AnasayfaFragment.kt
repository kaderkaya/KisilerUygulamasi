package com.kaderkayaarslan.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaderkayaarslan.kisileruygulamasi.R
import com.kaderkayaarslan.kisileruygulamasi.data.entity.Kişiler
import com.kaderkayaarslan.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.kaderkayaarslan.kisileruygulamasi.ui.adapter.KisilerAdapter


class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim:FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container, false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik ="Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        val kisilerListesi = ArrayList<Kişiler>()
        val k1 = Kişiler(1,"Ahmet","1111")
        val k2 = Kişiler(2,"Zeynep","2222")
        val k3 = Kişiler(3,"Beyza","3333")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)

        val adapter = KisilerAdapter(requireContext(),kisilerListesi)
        tasarim.kisilerAdapter = adapter

        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.toolbar_menu,menu)

                val item = menu.findItem(R.id.action_ara)
                val searchView = item.actionView as SearchView
                searchView.setOnQueryTextListener(this@AnasayfaFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
           return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        return tasarim.root
    }
    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayıtGecis)


    }

    override fun onQueryTextSubmit(query: String): Boolean {
        ara(query)
        return true

    }

    override fun onQueryTextChange(newText: String): Boolean {
        ara(newText)
        return true
    }
    fun ara(aramaKelimesi:String){
        Log.e("Kişi Ara",aramaKelimesi)

    }

    override fun onResume() {
        super.onResume()
        Log.e("Kişi Anasayfa","Dönüldü")
    }
}

