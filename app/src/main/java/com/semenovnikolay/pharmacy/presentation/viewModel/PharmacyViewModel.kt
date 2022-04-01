package com.semenovnikolay.pharmacy.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenovnikolay.pharmacy.domain.useCase.PharmacyUseCase
import kotlinx.coroutines.launch

class PharmacyViewModel (private val pharmacyUseCase: PharmacyUseCase): ViewModel() {

    val loadMedicines = pharmacyUseCase.loadMedicines()


    fun migration(context: Context) = viewModelScope.launch {
        pharmacyUseCase.startMigration(context)

    }

}