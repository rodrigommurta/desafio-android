package com.picpay.desafio.android.data.di

import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.picpay.desafio.android.data.features.contacts.local.database.ContactDatabase
import com.picpay.desafio.android.data.features.contacts.repository.ContactsRepositoryImpl
import com.picpay.desafio.android.data.features.contacts.service.ContactsService
import com.picpay.desafio.android.data.utils.Constants
import com.picpay.desafio.android.data.utils.Constants.OK_HTTP
import com.picpay.desafio.android.domain.features.contacts.repository.ContactsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DataModule {
    fun load() = loadKoinModules(
        listOf(
            RepositoryModule.getModule(),
            ServiceModule.getModule(),
            DaoModule.getModule(),
            networkModule,
        )
    )

    private val networkModule = module {
        single { createOkHttpClient() }

        single { GsonBuilder().create() }
    }

    private fun createOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor {
            Log.i(OK_HTTP, it)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }
}