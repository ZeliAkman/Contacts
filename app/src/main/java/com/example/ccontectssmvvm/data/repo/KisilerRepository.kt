package com.example.ccontectssmvvm.data.repo

import com.example.ccontectssmvvm.data.datasource.KisilerDataSource
import com.example.ccontectssmvvm.data.entity.Kisiler

class KisilerRepository(var kds:KisilerDataSource) {

    suspend fun kaydet(kisi_ad:String,kisi_tel:String)=kds.kaydet(kisi_ad,kisi_tel)

    suspend fun buttonGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String) = kds.buttonGuncelle(kisi_id, kisi_ad, kisi_tel)

    suspend fun sil(kisi_id:Int) = kds.sil(kisi_id)

    suspend fun kisileriYukle() : List<Kisiler> = kds.kisileriYukle()

    suspend fun ara(aramaKelimesi:String) :List<Kisiler> = kds.ara(aramaKelimesi)


}