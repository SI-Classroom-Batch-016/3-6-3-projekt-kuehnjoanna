package com.example.wauwau.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.wauwau.R
import com.example.wauwau.databinding.FragmentDogProfileBinding
import com.example.wauwau.databinding.FragmentMessageBinding

class MessageFragment : Fragment() {
    private lateinit var binding: FragmentMessageBinding
    val args: MessageFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMessageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendFormBTN.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Bitte Bestätigen")

            builder.setPositiveButton("Ja") { _, _ ->
                Toast.makeText(context, "Form sent, you can find it in your Inbox", Toast.LENGTH_SHORT).show()
            }

            builder.setNegativeButton("Nein") { _, _ ->

            }

            builder.show()
        }

    }


}