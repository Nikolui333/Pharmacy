package com.semenovnikolay.pharmacy.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.semenovnikolay.pharmacy.data.localDB.CardDao
import com.semenovnikolay.pharmacy.data.models.CardModel
import com.semenovnikolay.pharmacy.domain.repository.CardCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardRepository (private val dao: CardDao): CardCall {

    //val products = dao.loadMedicine()

    override suspend fun insert(cardModel: CardModel) {
       dao.insert(cardModel)    }

    override suspend fun updateProductToCard(cardModel: CardModel){
        dao.updateProductToCard(cardModel)
    }

    override fun loadMedicineFromCard(): LiveData<List<CardModel>> {
        return dao.loadMedicineFromCard()    }

    override fun loadMedicineToCardFromCardProduct(idProduct:String): LiveData<List<CardModel>> {
        return dao.loadMedicineToCardFromCardProduct(idProduct)    }

    override suspend fun deleteProductFromCard(idProduct:Int) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteProductFromCard(idProduct)}
    }

    override suspend fun deleteProductToCardFromCardProduct(idProduct:String) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteProductToCardFromCardProduct(idProduct)}
    }

    override suspend fun clear() {
        dao.clear()    }







}
