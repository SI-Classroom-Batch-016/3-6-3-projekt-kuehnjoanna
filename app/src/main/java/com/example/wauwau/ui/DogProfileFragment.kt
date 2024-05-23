package com.example.wauwau.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.wauwau.R
import com.example.wauwau.databinding.FragmentDogProfileBinding
import com.example.wauwau.databinding.FragmentHomeBinding


class DogProfileFragment : Fragment() {

    private lateinit var binding: FragmentDogProfileBinding
    private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDogProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val nameTV = binding.nameTV.text.toString()
        viewModel.selectedPetItem.observe(viewLifecycleOwner){
            binding.dogPhotoIV.setImageResource(it.picture)
            binding.dogAgeTV.text = it.age.toString()
            binding.dogGenderTV.text = it.gender
            binding.nameTV.text = it.name
            binding.dogDescriptionTV.text = it.description
        }

        binding.writeMessageBTN.setOnClickListener {
            findNavController().navigate(DogProfileFragmentDirections.actionDogProfileFragmentToMessageFragment(nameTV))
        }
    }
}