package com.example.lab_3.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_3.databinding.RecyclerRowBinding


class ExercisesAdapter(private val itemList: List<String>, private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<ExercisesAdapter.ExercisesHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExercisesHolder {
        val itemBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context))
        return ExercisesHolder(itemBinding, onItemClick)
    }

    override fun onBindViewHolder(holder: ExercisesHolder, position: Int){
        val exData = itemList[position]
        holder.bind(exData)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    class ExercisesHolder(private val itemBinding: RecyclerRowBinding, private val onItemClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemView.setOnClickListener{
                onItemClick(adapterPosition)
            }
        }
        fun bind(exerciseName: String){
            itemBinding.exercisesName.text = exerciseName
        }
    }
}