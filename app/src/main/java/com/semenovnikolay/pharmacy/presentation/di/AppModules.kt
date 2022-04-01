package com.semenovnikolay.pharmacy.presentation.di

import androidx.room.Room
import com.semenovnikolay.pharmacy.data.dataSource.PharmacyApiDataSource
import com.semenovnikolay.pharmacy.data.dataSource.PharmacyDataSource
import com.semenovnikolay.pharmacy.data.dataSourceIMPL.PharmacyApiDataSourceIMPL
import com.semenovnikolay.pharmacy.data.dataSourceIMPL.PharmacyDataSourceIMPL
import com.semenovnikolay.pharmacy.data.localDB.PharmacyDB
import com.semenovnikolay.pharmacy.data.repository.PharmacyRepository
import com.semenovnikolay.pharmacy.domain.repository.PharmacyCall
import com.semenovnikolay.pharmacy.domain.useCase.PharmacyUseCase
import com.semenovnikolay.pharmacy.presentation.viewModel.PharmacyViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val medicines = module{

    single {
        Room.databaseBuilder(androidContext(), PharmacyDB::class.java,
            "pharmacyDB").build()
    }

    single { get<PharmacyDB>().pharmacyDao }


    single<PharmacyDataSource> {
        PharmacyDataSourceIMPL(
            get()
        )
    }

    single<PharmacyApiDataSource> {
        PharmacyApiDataSourceIMPL(
            get()
        )
    }

    single<PharmacyCall> { PharmacyRepository(get(),get()) }

    single { PharmacyUseCase(get()) }

    viewModel { PharmacyViewModel(get()) }

}
