package com.semenovnikolay.pharmacy.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.semenovnikolay.pharmacy.R
import com.semenovnikolay.pharmacy.databinding.ActivityMainBinding
import com.semenovnikolay.pharmacy.presentation.Tabs.Account.Account
import com.semenovnikolay.pharmacy.presentation.Tabs.Card.ShoppingCart
import com.semenovnikolay.pharmacy.presentation.Tabs.Home
import com.semenovnikolay.pharmacy.presentation.Tabs.Medications.Medicine
import com.semenovnikolay.pharmacy.presentation.viewModel.MedicationsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    // ViewModel - класс, позволяющий Activity и фрагментам сохранять необходимые им объекты живыми при повороте экрана.
    // by viewModels() - делегат, которые прячет за собой создание вьюмодели
    private val medicationsViewModel: MedicationsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // как только данные поменяются, запустится эта строка
        medicationsViewModel.migration(this)

        setSupportActionBar(binding?.topMainMenu)
        // запуск фрагмента Home (в данном случае он является фрагментом по умолчанию)
        supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()

        // обработчик нажатий по вкладнкам
        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.homeBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Home()).commit()
                R.id.medicalBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Medicine()).commit()
                R.id.shoppingCardBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, ShoppingCart()).commit()
                R.id.accountBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, Account()).commit()
            }

            return@setOnItemSelectedListener true

        }
        binding?.bottomMainMenu?.selectedItemId = R.id.homeBottomMainMenu
    }
}