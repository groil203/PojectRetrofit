package com.example.lab_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_3.adapter.ExercisesAdapter
import com.example.lab_3.api.RetrofitInstance
import com.example.lab_3.databinding.FragmentListBinding


class ListFragment : Fragment(R.layout.fragment_list) {

   private lateinit var binding: FragmentListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.layoutManager = LinearLayoutManager(MainActivity())
        val bodyPartData = listOf(
            "back",
            "cardio",
            "chest",
            "lower arms",
            "lower legs",
            "neck",
            "shoulders",
            "upper arms",
            "upper legs",
            "waist"
        )

        val adapter = ExercisesAdapter(bodyPartData){ position ->
            RetrofitInstance.setPar(bodyPartData[position])
            findNavController().navigate(R.id.action_listFragment_to_infoFragment)
        }

        binding.recyclerView.adapter = adapter
    }

}