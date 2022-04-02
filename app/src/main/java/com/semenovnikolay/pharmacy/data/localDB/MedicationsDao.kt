package com.semenovnikolay.pharmacy.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semenovnikolay.pharmacy.data.models.MedicationsModel

@Dao
interface MedicationsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(medicationsModel: MedicationsModel)

    @Query("SELECT * FROM pharmacy_data_table")
    fun loadMedicines(): LiveData<List<MedicationsModel>>

    @Query("DELETE FROM pharmacy_data_table")
    suspend fun clear()
}