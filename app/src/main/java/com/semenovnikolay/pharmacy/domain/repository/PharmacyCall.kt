package com.semenovnikolay.pharmacy.domain.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.PharmacyModel

interface PharmacyCall {
    fun loadMedicines(): LiveData<List<PharmacyModel>>
    suspend fun startMigration(context: Context)
}