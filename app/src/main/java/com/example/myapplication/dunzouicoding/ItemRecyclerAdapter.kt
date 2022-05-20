package com.example.myapplication.dunzouicoding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.SingleItemLayoutBinding

class ItemRecyclerAdapter : RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder>() {

    private var itemList: MutableList<Item> = mutableListOf()

    class ItemViewHolder(private val binding: SingleItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item) {
            binding.textItemName.text = item.title
            binding.textItemUnit.text = item.quantity
            binding.textPrice.text = item.originalPrice
        }

        companion object {
            fun getInstance(parent: ViewGroup): ItemViewHolder {
                val binding = SingleItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ItemViewHolder(binding)
            }
        }
    }

    fun submitList(newItemList: List<Item>) {
        itemList.clear()
        itemList.addAll(newItemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder.getInstance(parent = parent)

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item = item)
    }

    override fun getItemCount(): Int = itemList.size
}