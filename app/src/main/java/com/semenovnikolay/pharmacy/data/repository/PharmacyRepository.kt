package com.semenovnikolay.pharmacy.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.dataSource.PharmacyApiDataSource
import com.semenovnikolay.pharmacy.data.dataSource.PharmacyDataSource
import com.semenovnikolay.pharmacy.data.models.PharmacyModel
import com.semenovnikolay.pharmacy.domain.repository.PharmacyCall

class PharmacyRepository (private val pharmacyApiDataSource: PharmacyApiDataSource,
                          private val pharmacyDataSource: PharmacyDataSource
): PharmacyCall {
    
   // val products = dao.loadPharmacy()

    override fun loadMedicines(): LiveData<List<PharmacyModel>> {
        return pharmacyDataSource.loadMedicines()    }



    override suspend fun startMigration(context: Context) {
        pharmacyDataSource.clear()
        pharmacyApiDataSource.startMigration(context)
    }
}