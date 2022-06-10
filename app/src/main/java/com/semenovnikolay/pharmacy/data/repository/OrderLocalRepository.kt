package com.semenovnikolay.pharmacy.data.repository

import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.localDB.OrderLocalDao
import com.semenovnikolay.pharmacy.data.models.OrderLocalModel
import com.semenovnikolay.pharmacy.domain.repository.OrderLocalCall

class OrderLocalRepository (private val orderLocalDao: OrderLocalDao
): OrderLocalCall {

    override suspend fun insert(orderLocalModel: OrderLocalModel) {
        orderLocalDao.insert(orderLocalModel)    }

    // получение данных о заказах
    override fun loadOrder(): LiveData<List<OrderLocalModel>> {
        return orderLocalDao.loadOrder()    }

    override suspend fun clear() {
        orderLocalDao.clear()    }

}