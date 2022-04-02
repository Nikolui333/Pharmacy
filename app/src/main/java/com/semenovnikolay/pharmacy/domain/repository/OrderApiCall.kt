package com.semenovnikolay.pharmacy.domain.repository

import android.content.Context

interface OrderApiCall {
    
    fun insert(context: Context, name:String, phone:String, description:String, priceOrder:String)
}