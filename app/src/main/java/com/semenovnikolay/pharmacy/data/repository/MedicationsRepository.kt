package com.semenovnikolay.pharmacy.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsApiDataSource
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsDataSource
import com.semenovnikolay.pharmacy.data.models.MedicationsModel
import com.semenovnikolay.pharmacy.domain.repository.MedicationsCall

class MedicationsRepository (private val medicationsApiDataSource: MedicationsApiDataSource,
                             private val medicationsDataSource: MedicationsDataSource
): MedicationsCall {

    // загрузка данных из локальной базы данных
    override fun loadMedicines(): LiveData<List<MedicationsModel>> {
        return medicationsDataSource.loadMedicines()    }

    // метод меграций
    override suspend fun startMigration(context: Context) {
        medicationsDataSource.clear()
        medicationsApiDataSource.startMigration(context)
    }
}