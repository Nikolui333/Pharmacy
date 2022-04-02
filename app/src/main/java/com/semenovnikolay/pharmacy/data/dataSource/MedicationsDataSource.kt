package com.semenovnikolay.pharmacy.data.dataSource

import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.MedicationsModel

interface MedicationsDataSource {
    fun insert(medicationsModel: MedicationsModel)
    fun loadMedicines(): LiveData<List<MedicationsModel>>
    suspend fun clear()
}