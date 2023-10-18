package com.kaderkayaarslan.kisileruygulamasi.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.kaderkayaarslan.kisileruygulamasi.R
import com.kaderkayaarslan.kisileruygulamasi.databinding.FragmentAnasayfaBinding


class AnasayfaFragment : Fragment() {
    private lateinit var tasarim:FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
      tasarim = FragmentAnasayfaBinding.inflate(inflater, container, false)

        tasarim.toolbarAnasayfa.title ="Kişiler"
        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarAnasayfa)

        tasarim.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.kisiKayıtGecis)
        }
        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.toolbar_menu,menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
           return false
            }
        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        return tasarim.root
    }
}

