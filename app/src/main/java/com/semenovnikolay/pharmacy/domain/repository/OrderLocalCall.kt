package com.semenovnikolay.pharmacy.domain.repository

import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.OrderLocalModel

interface OrderLocalCall {
    suspend fun insert(orderLocalModel: OrderLocalModel)

    // получение данных о заказах
    fun loadOrder(): LiveData<List<OrderLocalModel>>
    suspend fun clear()
}