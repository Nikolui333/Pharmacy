package com.semenovnikolay.pharmacy.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semenovnikolay.pharmacy.data.models.PharmacyModel

@Database(entities = [PharmacyModel::class], version = 1)
abstract class PharmacyDB : RoomDatabase() {
    abstract val pharmacyDao: PharmacyDao
}