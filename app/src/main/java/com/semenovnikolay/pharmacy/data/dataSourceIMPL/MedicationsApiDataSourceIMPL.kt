package com.semenovnikolay.pharmacy.data.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import com.semenovnikolay.pharmacy.data.api.ApiClient
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsApiDataSource
import com.semenovnikolay.pharmacy.data.dataSource.MedicationsDataSource
import com.semenovnikolay.pharmacy.data.models.MedicationsApiModel
import com.semenovnikolay.pharmacy.data.models.MedicationsModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MedicationsApiDataSourceIMPL (private val medicationsDataSource: MedicationsDataSource):
    MedicationsApiDataSource {



    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.loadMedicinesApi()
        call?.enqueue(object: Callback<ArrayList<MedicationsApiModel>> {
            override fun onResponse(
                call: Call<ArrayList<MedicationsApiModel>>,
                response: Response<ArrayList<MedicationsApiModel>>
            ) {


                var loadMedicines: ArrayList<MedicationsApiModel>? = null

                loadMedicines?.clear()

                loadMedicines = (response.body() as ArrayList<MedicationsApiModel>?)!!

                for (audit in loadMedicines) {

                    audit.id?.let {
                        MedicationsModel(
                            it,
                            audit.name.toString(),
                            audit.image.toString(),
                            audit.description.toString(),
                            audit.price.toString()
                        )
                    }?.let {
                        medicationsDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()


            }

            override fun onFailure(call: Call<ArrayList<MedicationsApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

}