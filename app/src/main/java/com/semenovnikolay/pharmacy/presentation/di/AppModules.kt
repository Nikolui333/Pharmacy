package com.semenovnikolay.pharmacy.presentation.di

import androidx.room.Room
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsApiDataSource
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsDataSource
import com.semenovnikolay.pharmacy.data.dataSourceIMPL.MedicationsApiDataSourceIMPL
import com.semenovnikolay.pharmacy.data.dataSourceIMPL.MedicationsDataSourceIMPL
import com.semenovnikolay.pharmacy.data.localDB.MedicationsDB
import com.semenovnikolay.pharmacy.data.repository.MedicationsRepository
import com.semenovnikolay.pharmacy.domain.repository.MedicationsCall
import com.semenovnikolay.pharmacy.domain.useCase.MedicationsUseCase
import com.semenovnikolay.pharmacy.presentation.viewModel.MedicationsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val medicines = module{

    single {
        Room.databaseBuilder(androidContext(), MedicationsDB::class.java,
            "pharmacyDB").build()
    }

    single { get<MedicationsDB>().medicationsDao }


    single<MedicationsDataSource> {
        MedicationsDataSourceIMPL(
            get()
        )
    }

    single<MedicationsApiDataSource> {
        MedicationsApiDataSourceIMPL(
            get()
        )
    }

    single<MedicationsCall> { MedicationsRepository(get(),get()) }

    single { MedicationsUseCase(get()) }

    viewModel { MedicationsViewModel(get()) }

}
