package com.semenovnikolay.pharmacy.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semenovnikolay.pharmacy.data.models.MedicationsModel

@Database(entities = [MedicationsModel::class], version = 1)
abstract class MedicationsDB : RoomDatabase() {
    abstract val medicationsDao: MedicationsDao
}