package com.semenovnikolay.pharmacy.data.dataSource

import android.content.Context

interface PharmacyApiDataSource {
    fun startMigration (context: Context)
}