package com.semenovnikolay.pharmacy.presentation.Tabs.Medications

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

        initRecyclerMedications()
        loadMedicine()

        return binding?.root
    }

    private fun initRecyclerMedications() {

        binding?.catalogMedications?.layoutManager =
            LinearLayoutManager(context)
        medicationsAdapter =
            MedicationsAdapter ({ medicationsModel: MedicationsModel ->
                addToCard(
                    medicationsModel
                )
            }, { medicationsModel: MedicationsModel ->
                removeFromCard(
                    medicationsModel
                )
            }, { idProduct:Int, addToBasket: AppCompatImageButton,
                 removeFromBasket: AppCompatImageButton ->
                loadMedicineToCardFromCardProduct(
                    idProduct, addToBasket, removeFromBasket
                )
            })
        binding?.catalogMedications?.adapter = medicationsAdapter

    }

    private fun loadMedicine() {

        medicationsViewModel.loadMedicines.observe(viewLifecycleOwner, Observer {
            medicationsAdapter?.setList(it)
            medicationsAdapter?.notifyDataSetChanged()
        })


    }

    private fun addToCard(medicationsModel: MedicationsModel) {
        cardViewModel.startInsert(medicationsModel.name, medicationsModel.image, medicationsModel.price, medicationsModel.id.toString(),
            "1")
    }

    private fun removeFromCard(medicationsModel: MedicationsModel) {
        cardViewModel.deleteProductToCardFromCardProduct(medicationsModel.id.toString())
    }

    private fun loadMedicineToCardFromCardProduct (idProduct:Int, addToBasket: AppCompatImageButton,
                                                 removeFromBasket: AppCompatImageButton
    ){

        cardViewModel.loadMedicineToCardFromCardProduct(idProduct.toString()).observe(viewLifecycleOwner, Observer {

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