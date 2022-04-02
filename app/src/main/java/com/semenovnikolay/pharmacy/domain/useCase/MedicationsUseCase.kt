package com.semenovnikolay.pharmacy.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.MedicationsModel
import com.semenovnikolay.pharmacy.domain.repository.MedicationsCall

class MedicationsUseCase (private val medicationsCall: MedicationsCall) {

    fun loadMedicines(): LiveData<List<MedicationsModel>> {

        return medicationsCall.loadMedicines()

    }

    suspend fun startMigration (context: Context) {

        medicationsCall.startMigration(context)

    }
}