package com.example.wauwau.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.wauwau.data.Message
import com.example.wauwau.data.Pet
import com.example.wauwau.databinding.MessageItemBinding
import com.example.wauwau.databinding.PetItemBinding

class MessageAdapter(
    val dataset: List<Message>,
    val itemClickedCallback: (Message) -> Unit,
): RecyclerView.Adapter<MessageAdapter.ItemViewHolder>() {
    inner class ItemViewHolder(val binding: MessageItemBinding): ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = MessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = dataset[position]
        val binding = holder.binding
        binding.messageTitleTV.text = data.title
        binding.messageBodyTV.text = data.content
       binding.messageITEM.setOnClickListener {
            itemClickedCallback(data)
        }
    }
}