package com.semenovnikolay.pharmacy.domain.useCase

import android.content.Context
import androidx.lifecycle.LiveData
import com.semenovnikolay.pharmacy.data.models.CardModel
import com.semenovnikolay.pharmacy.domain.repository.CardCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CardUseCase (private val cardCall: CardCall) {


    suspend fun insert(cardModel: CardModel) {
        cardCall.insert(cardModel)    }

    suspend fun updateProductToCard(cardModel: CardModel) {
        CoroutineScope(Dispatchers.IO).launch {
            cardCall.updateProductToCard(cardModel)}
    }

    fun loadMedicineFromCard(): LiveData<List<CardModel>> {
        return cardCall.loadMedicineFromCard()    }

    fun loadMedicineToCardFromCardProduct(idProduct:String): LiveData<List<CardModel>> {
        return cardCall.loadMedicineToCardFromCardProduct(idProduct)    }

    suspend fun deleteProductFromCard(idProduct:Int) {
        CoroutineScope(Dispatchers.IO).launch {
            cardCall.deleteProductFromCard(idProduct)}
    }

    suspend fun deleteProductToCardFromCardProduct(idProduct:String) {
        CoroutineScope(Dispatchers.IO).launch {
            cardCall.deleteProductToCardFromCardProduct(idProduct)}
    }

    suspend fun clear() {
        cardCall.clear()    }


}