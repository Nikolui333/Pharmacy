package com.semenovnikolay.pharmacy.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.dataSource.PharmacyDataSource
import com.semenovnikolay.pharmacy.data.localDB.PharmacyDao
import com.semenovnikolay.pharmacy.data.models.PharmacyModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PharmacyDataSourceIMPL (private val dao: PharmacyDao):
    PharmacyDataSource {

    override fun insert(pharmacyModel: PharmacyModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(pharmacyModel)}
    }

    override fun loadMedicines(): LiveData<List<PharmacyModel>> {
        return dao.loadMedicines()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }
}