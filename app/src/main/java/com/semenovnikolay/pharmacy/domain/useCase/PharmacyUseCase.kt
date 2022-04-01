package com.semenovnikolay.pharmacy.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.PharmacyModel
import com.semenovnikolay.pharmacy.domain.repository.PharmacyCall

class PharmacyUseCase (private val pharmacyCall: PharmacyCall) {

    fun loadMedicines(): LiveData<List<PharmacyModel>> {

        return pharmacyCall.loadMedicines()

    }

    suspend fun startMigration (context: Context) {

        pharmacyCall.startMigration(context)

    }
}