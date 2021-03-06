package com.semenovnikolay.pharmacy.presentation.Tabs.Medications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.semenovnikolay.pharmacy.R
import com.semenovnikolay.pharmacy.data.models.MedicationsModel
import com.semenovnikolay.pharmacy.databinding.MedicinesItemBinding
import com.squareup.picasso.Picasso

class MedicationsAdapter (private val addToCard:(MedicationsModel)->Unit, private val removeFromCard:(MedicationsModel)->Unit,
                          private val loadMedicationsToCardFromCardProduct:(Int, AppCompatImageButton, AppCompatImageButton)->Unit):
    RecyclerView.Adapter<MedicationsAdapter.MedicationsHolder>() {

    private val medications = ArrayList<MedicationsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationsHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: MedicinesItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.medicines_item, parent, false)
        return MedicationsHolder(binding)
    }

    override fun getItemCount(): Int {
        return medications.size
    }



    override fun onBindViewHolder(holder: MedicationsHolder, position: Int) {
        holder.bind(medications[position], addToCard, removeFromCard, loadMedicationsToCardFromCardProduct)

    }

    fun setList(medicationsList: List<MedicationsModel>) {
        medications.clear()
        medications.addAll(medicationsList)
    }

    class MedicationsHolder(val binding: MedicinesItemBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(
            medicationsModel: MedicationsModel, addToCard: (MedicationsModel) -> Unit,
            removeFromCard: (MedicationsModel) -> Unit,
            loadMedicineToCardFromCardProduct: (Int, AppCompatImageButton, AppCompatImageButton) -> Unit
        ) {
            // ???????????????? ???????????? ???? ??????????????????????
            val getImage = medicationsModel.image
            // ???????????????? ??????????????????????, ?????????????? ?????????????????? ???? ???????????? ?? ?????????????????? ?????? ?? imageMedications
            Picasso.get().load(getImage).into(binding.imageMedications)
            binding.nameMedications.text = medicationsModel.name
            binding.descriptionMedications.text = medicationsModel.description
            binding.priceMedications.text = medicationsModel.price

            binding.addToCard.setOnClickListener(View.OnClickListener {

                addToCard(medicationsModel)

            })

            binding.removeFromCard.setOnClickListener(View.OnClickListener {

                removeFromCard(medicationsModel)

            })

            loadMedicineToCardFromCardProduct(medicationsModel.id, binding.addToCard, binding.removeFromCard)

        }

    }
}