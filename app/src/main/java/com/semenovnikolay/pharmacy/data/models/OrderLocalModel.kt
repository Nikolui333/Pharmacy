package com.semenovnikolay.pharmacy.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "order_local_data_table")
class OrderLocalModel (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "order_local_id")
    val id:Int,

    @ColumnInfo(name = "order_local_nameUser")
    val nameUser:String,

    @ColumnInfo(name = "order_local_phoneUser")
    val phoneUser:String,

    // описание заказа
    @ColumnInfo(name = "order_local_description")
    val description:String,

    // общая цена
    @ColumnInfo(name = "order_local_totalPrice")
    val totalPrice:String
)
