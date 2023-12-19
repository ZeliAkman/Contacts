package com.example.ccontectssmvvm.di

import android.content.Context
import androidx.room.Room
import com.example.ccontectssmvvm.data.datasource.KisilerDataSource
import com.example.ccontectssmvvm.data.repo.KisilerRepository
import com.example.ccontectssmvvm.room.KisilerDao
import com.example.ccontectssmvvm.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideKisilerDataSource(kdao:KisilerDao) : KisilerDataSource{
        return KisilerDataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds:KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kds)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : KisilerDao{
        // veritabanına erişicez
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite").build() // veritabanı kopyası oluşturuyor
        return vt.getKisilerDao()
    }



}