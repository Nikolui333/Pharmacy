package com.semenovnikolay.pharmacy.data.api

import com.semenovnikolay.pharmacy.data.models.PharmacyApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("loadMedicines.php")
    fun loadMedicinesApi(): Call <ArrayList<PharmacyApiModel>>
}