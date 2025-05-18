package com.example.kisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.example.kisileruygulamasi.data.datasource.KisilerDataSource
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.data.repo.KisilerRepository
import com.example.kisileruygulamasi.room.KisilerDao
import com.example.kisileruygulamasi.room.Veritabani
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
    fun provideKisilerRepository(kisilerDataSource: KisilerDataSource) : KisilerRepository{
        return KisilerRepository(kisilerDataSource)
    }

    @Provides
    @Singleton
    fun provideKisilerDataSource(kisilerDao: KisilerDao) : KisilerDataSource {
        return KisilerDataSource(kisilerDao)
    }

    @Provides
    @Singleton
    fun provideKisilerDao(@ApplicationContext context: Context) : KisilerDao {
        val veritabani = Room.databaseBuilder(context, Veritabani::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite")
            .build()
        return veritabani.getKisilerDao()
    }
}

