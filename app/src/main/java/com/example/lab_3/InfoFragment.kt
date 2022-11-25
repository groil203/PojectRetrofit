package com.example.lab_3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab_3.adapter.InfoAdapter
import com.example.lab_3.databinding.FragmentInfoBinding


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private lateinit var adapter: InfoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.exInfoRecycler.layoutManager = LinearLayoutManager(MainActivity())
        val viewModel = ViewModelProvider(this)[InfoViewModel::class.java]
        adapter = InfoAdapter()
        binding.exInfoRecycler.adapter = adapter
        viewModel.getListExercises()
        viewModel.myInfoExercisesList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }

        binding.updateBtn.setOnClickListener {
            findNavController().popBackStack()
            findNavController().navigate(R.id.infoFragment)

        }
    }


}