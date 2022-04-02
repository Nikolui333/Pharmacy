package com.semenovnikolay.pharmacy.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.semenovnikolay.pharmacy.R
import com.semenovnikolay.pharmacy.data.models.MedicationsModel
import com.semenovnikolay.pharmacy.databinding.FragmentMedicineBinding
import com.semenovnikolay.pharmacy.presentation.viewModel.MedicationsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.semenovnikolay.pharmacy.presentation.viewModel.CardViewModel


class Medicine : Fragment() {

    private var binding: FragmentMedicineBinding? = null
    private var medicationsAdapter: MedicationsAdapter? = null
    private val medicationsViewModel: MedicationsViewModel by viewModel()
    private val cardViewModel: CardViewModel by viewModel()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_medicine, container, false)

        initRecyclerCoffee()
        loadCoffee()

        return binding?.root
    }

    private fun initRecyclerCoffee() {

        binding?.catalogMedications?.layoutManager =
            LinearLayoutManager(context)
        medicationsAdapter =
            MedicationsAdapter ({ coffeeModel: MedicationsModel ->
                addToCard(
                    coffeeModel
                )
            }, { coffeeModel: MedicationsModel ->
                removeFromCard(
                    coffeeModel
                )
            }, { idProduct:Int, addToBasket: AppCompatImageButton,
                 removeFromBasket: AppCompatImageButton ->
                loadCoffeeToCardFromCardProduct(
                    idProduct, addToBasket, removeFromBasket
                )
            })
        binding?.catalogMedications?.adapter = medicationsAdapter

    }

    private fun loadCoffee() {

        medicationsViewModel.loadMedicines.observe(viewLifecycleOwner, Observer {
            medicationsAdapter?.setList(it)
            medicationsAdapter?.notifyDataSetChanged()
        })


    }

    private fun addToCard(coffeeModel: MedicationsModel) {
        cardViewModel.startInsert(coffeeModel.name, coffeeModel.image, coffeeModel.price, coffeeModel.id.toString(),
            "1")
    }

    private fun removeFromCard(coffeeModel: MedicationsModel) {
        cardViewModel.deleteProductToCardFromCardProduct(coffeeModel.id.toString())
    }

    private fun loadCoffeeToCardFromCardProduct (idProduct:Int, addToBasket: AppCompatImageButton,
                                                 removeFromBasket: AppCompatImageButton
    ){

        cardViewModel.loadCoffeeToCardFromCardProduct(idProduct.toString()).observe(viewLifecycleOwner, Observer {

            val count = it.count()

            if (count>0) {
                addToBasket.visibility = View.GONE
                removeFromBasket.visibility = View.VISIBLE
            }
            else {
                addToBasket.visibility = View.VISIBLE
                removeFromBasket.visibility = View.GONE }
        })

    }
}