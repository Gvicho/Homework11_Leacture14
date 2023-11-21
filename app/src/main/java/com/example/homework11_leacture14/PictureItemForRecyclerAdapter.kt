package com.example.homework11_leacture14

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework11_leacture14.databinding.ItemForPicturesBinding

class PictureItemForRecyclerAdapter(private val listener: OnItemClickListener): ListAdapter<Animal, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    companion object {

        const val Item_Type_1 = 1

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Animal>() {
            override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class AnimalViewHolder(private val binding: ItemForPicturesBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(animal: Animal){
            binding.animalImige.setImageResource(animal.imige)
            binding.root.setOnClickListener{
                clickedOnPicture(animal)
            }
        }
    }

    fun clickedOnPicture(animal: Animal){
        listener.onItemClick(animal)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return when (item.itemType) {
            Item_Type_1 -> Item_Type_1
            else -> 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == Item_Type_1){
            return AnimalViewHolder(
                ItemForPicturesBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
        }else{
            //because write now I have only one type of Item
            return AnimalViewHolder(
                ItemForPicturesBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val animal = getItem(position)
        if(holder is AnimalViewHolder)holder.bind(animal)
    }
}

interface OnItemClickListener {
    fun onItemClick(animal: Animal)
}