package com.example.tarea1.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tarea1.model.Tarea


@Dao
interface TareaDao {

    @Insert(onConflict=OnConflictStrategy.IGNORE)
    suspend fun addLugar(tarea: Tarea)

    @Update(onConflict=OnConflictStrategy.IGNORE)
    suspend fun updateLugar(tarea: Tarea)

    @Delete
    suspend fun deleteLugar(tarea: Tarea)

    @Query("SELECt*FROM TAREA")
    fun getAllData():LiveData<List<Tarea>>


}