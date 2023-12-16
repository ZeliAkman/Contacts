package com.example.ccontectssmvvm.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ccontectssmvvm.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiDetayViewModel:ViewModel() {

    var krepo = KisilerRepository()

    fun buttonGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        CoroutineScope(Dispatchers.Main).launch {
            krepo.buttonGuncelle(kisi_id, kisi_ad, kisi_tel)
        }
    }
}