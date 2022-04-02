package com.semenovnikolay.pharmacy.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.MedicationsModel

interface MedicationsCall {
    fun loadMedicines(): LiveData<List<MedicationsModel>>
    suspend fun startMigration(context: Context)
}