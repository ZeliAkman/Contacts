package com.example.ccontectssmvvm.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "kisiler")
data class Kisiler(
                   @ColumnInfo(name="kisi_id") @NotNull var kisi_id:Int,
                   @ColumnInfo(name="kisi_ad") @NotNull var kisi_ad:String,
                   @ColumnInfo(name="kisi_tel") @NotNull var kisi_tel:String) : Serializable {
}