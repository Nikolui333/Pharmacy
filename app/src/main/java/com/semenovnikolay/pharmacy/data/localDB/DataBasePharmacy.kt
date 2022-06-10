package com.semenovnikolay.pharmacy.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import com.semenovnikolay.pharmacy.data.models.CardModel
import com.semenovnikolay.pharmacy.data.models.MedicationsModel
import com.semenovnikolay.pharmacy.data.models.OrderLocalModel

// В параметрах аннотации Database указываем, какие Entity будут использоваться, и версию базы.
// Для каждого Entity класса из списка entities будет создана таблица.
// Entity класс используется для создания таблицы


@Database(entities = [CardModel::class, MedicationsModel::class, OrderLocalModel::class], version = 1)
abstract class DataBasePharmacy : RoomDatabase() {
    abstract val cardDao: CardDao
    abstract val medicationsDao: MedicationsDao
    abstract val orderLocalDao: OrderLocalDao
}







