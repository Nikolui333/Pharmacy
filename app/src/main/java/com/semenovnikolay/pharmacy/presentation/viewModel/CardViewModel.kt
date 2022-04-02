package com.semenovnikolay.pharmacy.presentation.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.semenovnikolay.pharmacy.data.models.CardModel
import com.semenovnikolay.pharmacy.domain.useCase.CardUseCase
import kotlinx.coroutines.launch

class CardViewModel (private val cardUseCase: CardUseCase): ViewModel() {


    fun startInsert(nameProduct:String, imageProduct:String, priceProduct:String, idProduct:String, countProduct:String) {
        insert(
            CardModel(0, nameProduct, imageProduct, priceProduct, idProduct, countProduct, (priceProduct.toInt()*countProduct.toInt()).toString())
        )
    }

    private fun insert(cardModel: CardModel) = viewModelScope.launch{

        cardUseCase.insert(cardModel)
    }

    fun updateProductToCard(cardModel: CardModel) = viewModelScope.launch{

        cardUseCase.updateProductToCard(cardModel)
    }

    val loadMedicineFromCard = cardUseCase.loadMedicineFromCard()

    fun loadMedicineToCardFromCardProduct(idProduct:String): LiveData<List<CardModel>> {
        return cardUseCase.loadMedicineToCardFromCardProduct(idProduct)
    }

    fun deleteProductFromCard(idProduct:Int) = viewModelScope.launch{

        cardUseCase.deleteProductFromCard(idProduct)
    }

    fun deleteProductToCardFromCardProduct(idProduct:String) = viewModelScope.launch{

        cardUseCase.deleteProductToCardFromCardProduct(idProduct)
    }



    fun clearCard() = viewModelScope.launch{

        cardUseCase.clear()
    }

}