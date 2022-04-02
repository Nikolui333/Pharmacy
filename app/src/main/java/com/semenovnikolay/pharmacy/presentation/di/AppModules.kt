package com.semenovnikolay.pharmacy.presentation.di

import androidx.room.Room
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsApiDataSource
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsDataSource
import com.semenovnikolay.pharmacy.data.dataSourceIMPL.MedicationsApiDataSourceIMPL
import com.semenovnikolay.pharmacy.data.dataSourceIMPL.MedicationsDataSourceIMPL
import com.semenovnikolay.pharmacy.data.localDB.DataBasePharmacy
import com.semenovnikolay.pharmacy.data.localDB.MedicationsDB
import com.semenovnikolay.pharmacy.data.repository.CardRepository
import com.semenovnikolay.pharmacy.data.repository.MedicationsRepository
import com.semenovnikolay.pharmacy.data.repository.OrderApiRepository
import com.semenovnikolay.pharmacy.data.repository.OrderLocalRepository
import com.semenovnikolay.pharmacy.domain.repository.CardCall
import com.semenovnikolay.pharmacy.domain.repository.MedicationsCall
import com.semenovnikolay.pharmacy.domain.repository.OrderApiCall
import com.semenovnikolay.pharmacy.domain.repository.OrderLocalCall
import com.semenovnikolay.pharmacy.domain.useCase.CardUseCase
import com.semenovnikolay.pharmacy.domain.useCase.MedicationsUseCase
import com.semenovnikolay.pharmacy.domain.useCase.OrderApiUseCase
import com.semenovnikolay.pharmacy.domain.useCase.OrderLocalUseCase
import com.semenovnikolay.pharmacy.presentation.viewModel.CardViewModel
import com.semenovnikolay.pharmacy.presentation.viewModel.MedicationsViewModel
import com.semenovnikolay.pharmacy.presentation.viewModel.OrderApiViewModel
import com.semenovnikolay.pharmacy.presentation.viewModel.OrderLocalViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val medicines = module{

    single {
        Room.databaseBuilder(androidContext(), DataBasePharmacy::class.java,
            "dbC").build()
    }

    single { get<DataBasePharmacy>().medicationsDao }


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

val card = module{

    single {
        Room.databaseBuilder(androidContext(), DataBasePharmacy::class.java,
            "dbO").build()
    }

    single { get<DataBasePharmacy>().cardDao }


    single<CardCall> { CardRepository(get()) }

    single { CardUseCase(get()) }

    viewModel { CardViewModel(get()) }

}

val order = module{

    single {
        Room.databaseBuilder(androidContext(), DataBasePharmacy::class.java,
            "dbS").build()
    }

    single { get<DataBasePharmacy>().orderLocalDao }


    single<OrderLocalCall> { OrderLocalRepository(get()) }

    single { OrderLocalUseCase(get()) }

    viewModel { OrderLocalViewModel(get()) }

}

val orderApi= module{

    single<OrderApiCall> { OrderApiRepository() }

    single { OrderApiUseCase(get()) }

    viewModel { OrderApiViewModel(get()) }

}