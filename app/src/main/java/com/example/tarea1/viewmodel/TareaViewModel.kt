package com.example.tarea1.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.tarea1.data.TareaDatabase
import com.example.tarea1.model.Tarea
import com.example.tarea1.repository.TareaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TareaViewModel (application: Application):AndroidViewModel(application) {

    val getAllData:LiveData<List<Tarea>>


    private val repository: TareaRepository


    init{
        val tareaDao= TareaDatabase.getDatabase(application).tareaDao()
        repository= TareaRepository(tareaDao)
        getAllData=repository.getAllData
    }

    fun addCancion(tarea:Tarea){
        viewModelScope.launch (Dispatchers.IO){
            repository.addCancion(tarea)
        }
    }

    fun updateCancion(tarea: Tarea){
        viewModelScope.launch (Dispatchers.IO){
            repository.updateCancion(tarea)
        }
    }

    fun deleteCancion(tarea: Tarea){
        viewModelScope.launch (Dispatchers.IO){
            repository.deleteCancion(tarea)
        }
    }
}
