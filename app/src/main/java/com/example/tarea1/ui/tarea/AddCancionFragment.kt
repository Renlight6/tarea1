package com.example.tarea1.ui.tarea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tarea1.R
import com.example.tarea1.databinding.FragmentAddCancionBinding
import com.example.tarea1.model.Tarea
import com.example.tarea1.viewmodel.TareaViewModel

class AddCancionFragment : Fragment() {
    private lateinit var tareaViewModel:TareaViewModel
    private var _binding:FragmentAddCancionBinding?=null
    private val binding get()=_binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_cancion, container, false)
        return binding.root
    }
   private  fun addCancion(){
       var nombre= binding.etCancion.text.toString()
       if(nombre.isNotEmpty()) {
           var cancion = binding.etCancion.text.toString()
           var artista = binding.etArtista.text.toString()
           var album = binding.etAlbum.text.toString()
           var año = binding.etLanzamiento.text.toString()
           val tarea = Tarea(0,cancion, artista, album, año,"","",)
           tareaViewModel.addCancion(tarea)
           Toast.makeText(requireContext(), "Cancion agregada", Toast.LENGTH_SHORT).show()
           findNavController().navigate(R.id.action_addCancionFragment_to_nav_tarea)
       }else{
           Toast.makeText(requireContext(), "Faltan datos", Toast.LENGTH_SHORT).show()
       }
   }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}