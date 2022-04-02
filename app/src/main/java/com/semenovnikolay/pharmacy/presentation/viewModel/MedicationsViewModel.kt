package com.semenovnikolay.pharmacy.presentation.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenovnikolay.pharmacy.domain.useCase.MedicationsUseCase
import kotlinx.coroutines.launch

class MedicationsViewModel (private val medicationsUseCase: MedicationsUseCase): ViewModel() {

    val loadMedicines = medicationsUseCase.loadMedicines()

    fun migration(context: Context) = viewModelScope.launch {
        medicationsUseCase.startMigration(context)

    }

}