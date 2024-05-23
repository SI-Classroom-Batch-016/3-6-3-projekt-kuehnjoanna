package com.example.wauwau.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.wauwau.R
import com.example.wauwau.adapter.MessageAdapter
import com.example.wauwau.adapter.PetAdapter
import com.example.wauwau.data.Datasource
import com.example.wauwau.data.Message
import com.example.wauwau.data.Pet
import com.example.wauwau.databinding.FragmentInboxBinding
import com.example.wauwau.databinding.MessageItemBinding


class InboxFragment : Fragment() {
private lateinit var binding: FragmentInboxBinding
private val viewModel: WauWauViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
binding  = FragmentInboxBinding.inflate(layoutInflater)
    return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val data = Datasource.messages

        val itemClickedCallback: (Message) -> Unit  = {
            viewModel.selectedMessageItem(it)

            findNavController().navigate(R.id.messageFragment)
        }
        val adapter = MessageAdapter(data, itemClickedCallback)
        binding.inboxRV.adapter = adapter
    }
}