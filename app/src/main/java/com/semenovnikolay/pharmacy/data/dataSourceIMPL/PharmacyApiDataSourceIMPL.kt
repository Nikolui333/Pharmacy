package com.semenovnikolay.pharmacy.data.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import com.semenovnikolay.pharmacy.data.api.ApiClient
import com.semenovnikolay.pharmacy.data.dataSource.PharmacyApiDataSource
import com.semenovnikolay.pharmacy.data.dataSource.PharmacyDataSource
import com.semenovnikolay.pharmacy.data.models.PharmacyApiModel
import com.semenovnikolay.pharmacy.data.models.PharmacyModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PharmacyApiDataSourceIMPL (private val pharmacyDataSource: PharmacyDataSource):
    PharmacyApiDataSource {



    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.loadMedicinesApi()
        call?.enqueue(object: Callback<ArrayList<PharmacyApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<PharmacyApiModel>>,
                response: Response<ArrayList<PharmacyApiModel>>
            ) {


                var loadMedicines: ArrayList<PharmacyApiModel>? = null

                loadMedicines?.clear()

                loadMedicines = (response.body() as ArrayList<PharmacyApiModel>?)!!

                for (audit in loadMedicines) {

                    audit.id?.let {
                        PharmacyModel(
                            it,
                            audit.name.toString(),
                            audit.image.toString(),
                            audit.description.toString(),
                            audit.price.toString()
                        )
                    }?.let {
                        pharmacyDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<PharmacyApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

}