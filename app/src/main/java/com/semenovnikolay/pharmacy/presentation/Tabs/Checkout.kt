package com.semenovnikolay.pharmacy.presentation.Tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.semenovnikolay.pharmacy.R
import com.semenovnikolay.pharmacy.data.models.CardModel
import com.semenovnikolay.pharmacy.databinding.CheckoutBinding
import com.semenovnikolay.pharmacy.presentation.viewModel.CardViewModel
import com.semenovnikolay.pharmacy.presentation.viewModel.OrderApiViewModel
import com.semenovnikolay.pharmacy.presentation.viewModel.OrderLocalViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class Checkout : BottomSheetDialogFragment() {

    private var binding: CheckoutBinding? = null
    private val cardViewModel: CardViewModel by viewModel()
    private val orderLocalViewModel: OrderLocalViewModel by viewModel()
    private val orderApiViewModel: OrderApiViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.checkout, container, false)

        binding?.submitCheckout?.setOnClickListener(View.OnClickListener {

            cardViewModel.loadMedicineFromCard.observe(viewLifecycleOwner, Observer {

                val totalOrder:Int = it.sumOf<CardModel> { it.totalPrice.toInt() }

                val descriptionOrder = it.map { it.name + ": count - " + it.count + ", price - " + it.totalPrice + " $; " }.joinToString("")

                orderLocalViewModel.startInsert(binding?.enterNameCheckout?.text.toString(),
                    binding?.enterPhoneCheckout?.text.toString(), descriptionOrder,
                    totalOrder.toString() )

                orderApiViewModel.insert((context as FragmentActivity), binding?.enterNameCheckout?.text.toString(),
                    binding?.enterPhoneCheckout?.text.toString(), descriptionOrder,
                    totalOrder.toString())


                binding?.enterNameCheckout?.setText("")
                binding?.enterPhoneCheckout?.setText("")


                dismiss()

                cardViewModel.clearCard()



            })


        })

        return binding?.root
    }





}