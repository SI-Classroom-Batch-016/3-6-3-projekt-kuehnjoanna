package com.example.wauwau.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.wauwau.data.Pet
import com.example.wauwau.databinding.PetItemBinding

class PetAdapter(
        val dataset: List<Pet>
): RecyclerView.Adapter<PetAdapter.ItemViewHolder>() {
        inner class ItemViewHolder(val binding: PetItemBinding): ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
                val binding = PetItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ItemViewHolder(binding)

        }

        override fun getItemCount(): Int {
                return dataset.size
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
                val data = dataset[position]
                val binding = holder.binding
        }
}