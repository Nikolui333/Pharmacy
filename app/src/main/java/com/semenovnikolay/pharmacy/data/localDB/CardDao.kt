package com.semenovnikolay.pharmacy.data.localDB

import androidx.lifecycle.LiveData
import androidx.room.*
import com.semenovnikolay.pharmacy.data.models.CardModel


@Dao
interface CardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cardModel: CardModel)

    @Query("SELECT * FROM card_data_table")
    fun loadMedicineFromCard(): LiveData<List<CardModel>>

    @Query("SELECT * FROM card_data_table WHERE card_idProduct = :idProduct")
    fun loadMedicineToCardFromCardProduct(idProduct:String): LiveData<List<CardModel>>

    @Update
    suspend fun updateProductToCard(cardModel: CardModel)

    @Query("DELETE FROM card_data_table WHERE card_id = :idProductToCard")
    suspend fun deleteProductFromCard(idProductToCard:Int)

    @Query("DELETE FROM card_data_table WHERE card_idProduct = :idProduct")
    suspend fun deleteProductToCardFromCardProduct(idProduct:String)

    @Query("DELETE FROM card_data_table")
    suspend fun clear()
}