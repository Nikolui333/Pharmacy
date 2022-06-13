package com.semenovnikolay.pharmacy.presentation.Tabs.Account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.semenovnikolay.pharmacy.R
import com.semenovnikolay.pharmacy.presentation.viewModel.OrderLocalViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.semenovnikolay.pharmacy.databinding.FragmentAccountBinding


class Account : Fragment() {

    private var binding: FragmentAccountBinding? = null

    private var orderAdapter: OrderAdapter? = null
    private val orderLocalViewModel: OrderLocalViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false)

        initRecyclerOrder()

        loadOrders()

        binding?.clearOrders?.setOnClickListener(View.OnClickListener {
            orderLocalViewModel.clearOrders()
        })

        return binding?.root
    }

    private fun initRecyclerOrder() {

        binding?.listOrders?.layoutManager =
            LinearLayoutManager(context)
        orderAdapter = OrderAdapter()
        binding?.listOrders?.adapter = orderAdapter

    }

    private fun loadOrders() {

        orderLocalViewModel.loadOrder.observe(viewLifecycleOwner, Observer {
            // setList наполняет адаптер данными
            orderAdapter?.setList(it)
            orderAdapter?.notifyDataSetChanged()

        })
    }
}