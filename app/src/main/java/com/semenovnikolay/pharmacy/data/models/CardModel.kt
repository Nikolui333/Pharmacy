package com.semenovnikolay.pharmacy.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "card_data_table")
class CardModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "card_id")
    val id:Int,

    @ColumnInfo(name = "card_name")
    val name:String,

    @ColumnInfo(name = "card_image")
    val image:String,

    @ColumnInfo(name = "card_price")
    val price:String,

    @ColumnInfo(name = "card_idProduct")
    val idProduct:String,

    @ColumnInfo(name = "card_count")
    val count:String,

    @ColumnInfo(name = "card_total_price")
    val totalPrice:String
)