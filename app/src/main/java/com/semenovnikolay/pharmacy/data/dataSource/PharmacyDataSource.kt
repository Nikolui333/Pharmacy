package com.semenovnikolay.pharmacy.data.dataSource

import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.PharmacyModel

interface PharmacyDataSource {
    fun insert(pharmacyModel: PharmacyModel)
    fun loadMedicines(): LiveData<List<PharmacyModel>>
    suspend fun clear()
}