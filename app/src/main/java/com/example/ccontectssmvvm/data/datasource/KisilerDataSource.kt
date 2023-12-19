package com.example.ccontectssmvvm.data.datasource

import android.util.Log
import com.example.ccontectssmvvm.data.entity.Kisiler
import com.example.ccontectssmvvm.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kdao:KisilerDao) {

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext kdao.kisileriYukle()
        }


    suspend fun ara(aramaKelimesi:String) :List<Kisiler> =
        withContext(Dispatchers.IO){
            return@withContext kdao.ara(aramaKelimesi)
        }



    suspend fun kaydet(kisi_ad:String,kisi_tel:String){
        val yeniKisi = Kisiler(0,kisi_ad,kisi_tel)
        kdao.kaydet(yeniKisi)
        Log.e("Kişi Kaydet","$kisi_ad - $kisi_tel")
    }

    suspend fun buttonGuncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String){
        val guncellenenKisi = Kisiler(kisi_id,kisi_ad,kisi_tel)
        kdao.guncelle(guncellenenKisi)
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }
    suspend fun sil(kisi_id:Int){
        val silinenKisi = Kisiler(kisi_id,"","")
        kdao.guncelle(silinenKisi)
        Log.e("Kişi Sil",kisi_id.toString())
    }



}