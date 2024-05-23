package com.example.wauwau.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.wauwau.R
import com.example.wauwau.adapter.PetAdapter
import com.example.wauwau.data.Datasource
import com.example.wauwau.data.Pet
import com.example.wauwau.databinding.FragmentPetSearchBinding


class PetSearchFragment : Fragment() {
private lateinit var binding: FragmentPetSearchBinding
private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPetSearchBinding.inflate(layoutInflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = Datasource.data

        val itemClickedCallback: (Pet) -> Unit  = {
            viewModel.selectedPetItem(it)

            findNavController().navigate(PetSearchFragmentDirections.actionPetSearchFragmentToDogProfileFragment())
        }
        val adapter = PetAdapter(data, itemClickedCallback)
        binding.petsRV.adapter = adapter
    }

}