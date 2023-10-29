package com.kaderkayaarslan.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.kaderkayaarslan.kisileruygulamasi.R
import com.kaderkayaarslan.kisileruygulamasi.data.entity.Kişiler
import com.kaderkayaarslan.kisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.kaderkayaarslan.kisileruygulamasi.ui.adapter.KisilerAdapter
import com.kaderkayaarslan.kisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.kaderkayaarslan.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel


class AnasayfaFragment : Fragment(),SearchView.OnQueryTextListener {
    private lateinit var tasarim:FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container, false)
        tasarim.anasayfaFragment = this
        tasarim.anasayfaToolbarBaslik ="Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

      viewModel.kisilerListesi.observe(viewLifecycleOwner){
          val adapter = KisilerAdapter(requireContext(),it,viewModel)
          tasarim.kisilerAdapter = adapter
      }


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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.kisiKayıtGecis)


    }

    override fun onQueryTextSubmit(query: String): Boolean {
       viewModel.ara(query)
        return true

    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }


    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }

}


