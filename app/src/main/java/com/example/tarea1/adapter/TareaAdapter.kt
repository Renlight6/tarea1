package com.example.tarea1.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.tarea1.databinding.TareaFilaBinding
import com.example.tarea1.model.Tarea
import com.example.tarea1.ui.tarea.TareaFragmentDirections

class TareaAdapter:RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {
    private var listaTarea = emptyList<Tarea>()

    inner class TareaViewHolder(private val itemBinding: TareaFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun dibuja(tarea: Tarea) {
            itemBinding.tvCancion.text=tarea.Cancion
            itemBinding.tvArtista.text=tarea.Artista
            itemBinding.tvLanzamiento.text=tarea.year
            itemBinding.tvAlbum.text=tarea.Album
            itemBinding.vistaFila.setOnClickListener{

            }


    }
}
    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val tarea=listaTarea[position]
        holder.dibuja(tarea)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val itemBinding=TareaFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TareaViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return listaTarea.size
    }
    fun setData(tarea:List<Tarea>){
        this.listaTarea=tarea
        notifyDataSetChanged()
    }

}