package com.example.tarea1.repository

import androidx.lifecycle.LiveData
import com.example.tarea1.data.TareaDao
import com.example.tarea1.model.Tarea

class TareaRepository (private val tareaDao: TareaDao){


    val getAllData: LiveData<List<Tarea>> =tareaDao.getAllData()


    suspend fun addCancion(tarea:Tarea){
        tareaDao.addLugar(tarea)
    }

    suspend fun updateCancion(tarea:Tarea){
        tareaDao.updateLugar(tarea)
    }

    suspend fun deleteCancion(tarea:Tarea){
        tareaDao.deleteLugar(tarea)
    }
}