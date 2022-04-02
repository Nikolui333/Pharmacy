package com.semenovnikolay.pharmacy.data.dataSourceIMPL

import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsDataSource
import com.semenovnikolay.pharmacy.data.localDB.MedicationsDao
import com.semenovnikolay.pharmacy.data.models.MedicationsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MedicationsDataSourceIMPL (private val dao: MedicationsDao):
    MedicationsDataSource {

    override fun insert(medicationsModel: MedicationsModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(medicationsModel)}
    }

    override fun loadMedicines(): LiveData<List<MedicationsModel>> {
        return dao.loadMedicines()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }
}