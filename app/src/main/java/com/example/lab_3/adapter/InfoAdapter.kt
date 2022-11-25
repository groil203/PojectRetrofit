package com.example.lab_3.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab_3.R
import com.example.lab_3.databinding.RecyclerExerciseBinding
import com.example.lab_3.model.ExerciseItem


class InfoAdapter:
    RecyclerView.Adapter<InfoAdapter.InfoViewHolder>() {

    private var itemList = emptyList<ExerciseItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InfoViewHolder {
       val itemBinding = RecyclerExerciseBinding.inflate(LayoutInflater.from(parent.context))
        return InfoViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) {
        val infoExerciseList = itemList[position]

        holder.bind(infoExerciseList.name, infoExerciseList.equipment, infoExerciseList.gifUrl)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class InfoViewHolder(private val itemBinding: RecyclerExerciseBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(nameEx: String, equipmentEx: String, imageView: String?){
            itemBinding.nameEx.text = nameEx
            itemBinding.equipmentEx.text = equipmentEx
            Glide.with(itemView)
                .load(imageView)
                .centerCrop()
                .placeholder(itemBinding.imageView.drawable)
                .error(R.drawable.ic_launcher_background)
                .into(itemBinding.imageView)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<ExerciseItem>){
        itemList = list
        notifyDataSetChanged()
    }
}