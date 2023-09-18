package com.kaderkayaarslan.kisileruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kaderkayaarslan.kisileruygulamasi.R


class KisiKayitFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_kisi_kayit, container, false)
    }


}