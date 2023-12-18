package com.example.ccontectssmvvm.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ccontectssmvvm.R
import com.example.ccontectssmvvm.data.entity.Kisiler
import com.example.ccontectssmvvm.databinding.FragmentAnasayfaBinding
import com.example.ccontectssmvvm.ui.adapter.KisilerAdapter
import com.example.ccontectssmvvm.ui.viewmodel.AnasayfaViewModel
import com.example.ccontectssmvvm.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa ,container, false)

        // Code will be here

        binding.anasayfaNesnesi=this
        binding.toolbarBaslik = "Kişiler"

        // live data işlemi / kişileri ykleme

        viewModel.kisilerListesi.observe(viewLifecycleOwner){
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter = kisilerAdapter
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }


    // viewModel Bağlama

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel :AnasayfaViewModel by viewModels()
        viewModel=tempViewModel
    }

    //ektension ile geçişi kısaltık
    fun fabTikla(it:View){
        Navigation.gecisYap(it,R.id.action_anasayfaFragment_to_kisiKayitFragment)
    }

    /*fun ara(aramaKelimesi:String){
    // kod ustende göstericeğimiz için bu kısma gerek yok
        Log.e("Kişi Ara",aramaKelimesi)
    }*/


    // Anasayfaya Geri Dönme işlemi
    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle()
    }


}