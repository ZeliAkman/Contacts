package com.example.ccontectssmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ccontectssmvvm.R
import com.example.ccontectssmvvm.databinding.FragmentKisiKayitBinding
import com.example.ccontectssmvvm.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =FragmentKisiKayitBinding.inflate(inflater, container, false)

        binding.kisiKayitNesnesi= this
        binding.toolbarBaslik = "Kişi Kayıt"


        return binding.root
    }

    // viewModel Bağlama

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiKayitViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun kaydet(kisi_ad:String,kisi_tel:String){
        viewModel.kaydet(kisi_ad,kisi_tel)
    }


}