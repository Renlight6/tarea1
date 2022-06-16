package com.example.tarea1.ui.tarea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tarea1.R
import com.example.tarea1.adapter.TareaAdapter

import com.example.tarea1.databinding.FragmentTareaBinding
import com.example.tarea1.viewmodel.TareaViewModel

class TareaFragment : Fragment() {

    private var _binding: FragmentTareaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tareaViewModel =
            ViewModelProvider(this).get(TareaViewModel::class.java)

        _binding=FragmentTareaBinding.inflate(inflater,container,false)
        binding.fbAgregar.setOnClickListener{
            findNavController().navigate(R.id.action_nav_tarea_to_addCancionFragment)
        }
        val tareaAdapter=TareaAdapter()
        val reciclador=binding.reciclador
        reciclador.adapter=tareaAdapter
        reciclador.layoutManager=LinearLayoutManager(requireContext())
        tareaViewModel.getAllData.observe(viewLifecycleOwner){tareas ->
            tareaAdapter.setData(tareas)
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}