package com.example.myassignment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myassignment.databinding.ItemRecyclerBinding


class ItemAdapter(private  val data: ArrayList<ItemData>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class ViewHolder(private val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemData) {
            binding.itemPic.setImageResource(item.img)
            binding.itemText.text = item.name
        }
    }

}












