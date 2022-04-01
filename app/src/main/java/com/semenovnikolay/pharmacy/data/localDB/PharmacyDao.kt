package com.semenovnikolay.pharmacy.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semenovnikolay.pharmacy.data.models.PharmacyModel

@Dao
interface PharmacyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pharmacyModel: PharmacyModel)

    @Query("SELECT * FROM pharmacy_data_table")
    fun loadMedicines(): LiveData<List<PharmacyModel>>

    @Query("DELETE FROM pharmacy_data_table")
    suspend fun clear()
}