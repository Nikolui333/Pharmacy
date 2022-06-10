package com.semenovnikolay.pharmacy.presentation.Tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.semenovnikolay.pharmacy.R
import com.semenovnikolay.pharmacy.databinding.FragmentHomeBinding
import com.semenovnikolay.pharmacy.presentation.Proposal.ProposalAdapter

class Home : Fragment() {
    private var binding:FragmentHomeBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding?.slider?.adapter = ProposalAdapter(context as FragmentActivity)

        val tabLayoutMediator = binding?.tabSlider?.let {
            binding?.slider?.let { it1 ->
                TabLayoutMediator(it,
                    it1,
                    TabLayoutMediator.TabConfigurationStrategy { tab, position -> })
            }
        }
        tabLayoutMediator?.attach()

        return binding?.root
    }
}