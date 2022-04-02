package com.semenovnikolay.pharmacy.data.api

import com.semenovnikolay.pharmacy.data.models.MedicationsApiModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("loadMedicines.php")
    fun loadMedicinesApi(): Call <ArrayList<MedicationsApiModel>>
}