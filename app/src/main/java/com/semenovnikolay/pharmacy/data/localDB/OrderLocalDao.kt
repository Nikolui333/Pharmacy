package com.semenovnikolay.pharmacy.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semenovnikolay.pharmacy.data.models.OrderLocalModel

@Dao
interface OrderLocalDao {

    // записывает данные в локальную базу данных с сервера
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(orderLocalModel: OrderLocalModel)

    // получение данных о заказах
    @Query("SELECT * FROM order_local_data_table")
    fun loadOrder(): LiveData<List<OrderLocalModel>>

    @Query("DELETE FROM order_local_data_table")
    suspend fun clear()
}

