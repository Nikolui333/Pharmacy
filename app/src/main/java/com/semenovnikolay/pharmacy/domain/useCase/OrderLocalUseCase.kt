package com.semenovnikolay.pharmacy.domain.useCase

import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.OrderLocalModel
import com.semenovnikolay.pharmacy.domain.repository.OrderLocalCall

class OrderLocalUseCase (private val orderLocalCall: OrderLocalCall) {

    suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalCall.insert(orderLocalModel)    }

    // получение данных о заказах
    fun loadOrder(): LiveData<List<OrderLocalModel>> {
        return orderLocalCall.loadOrder()    }
    // очистка истории заказов
    suspend fun clear() {
        orderLocalCall.clear()    }

}