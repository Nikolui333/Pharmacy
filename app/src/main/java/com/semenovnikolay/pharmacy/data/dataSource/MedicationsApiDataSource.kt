package com.semenovnikolay.pharmacy.data.dataSource

import android.content.Context

interface MedicationsApiDataSource {
    fun startMigration (context: Context)
}