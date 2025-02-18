package com.picpay.desafio.android.data.di

import com.picpay.desafio.android.data.features.contacts.local.database.ContactDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DaoModule {
    fun getModule() = daoModule

    private val daoModule = module {
        single { ContactDatabase.getInstance(androidContext()).dao }
    }
}