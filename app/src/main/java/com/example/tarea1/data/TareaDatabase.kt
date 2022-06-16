package com.example.tarea1.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tarea1.model.Tarea

@Database(entities = [Tarea::class], version = 1, exportSchema = false)

        abstract class TareaDatabase : RoomDatabase(){
        abstract fun tareaDao():TareaDao

        companion object{
            @Volatile
            private var INSTANCE: TareaDatabase?=null

            fun getDatabase(context:android.content.Context):TareaDatabase{
                val tempInstance= INSTANCE
                if (tempInstance!=null){
                    return tempInstance
                }
                synchronized(this){
                    val instace= Room.databaseBuilder(
                        context.applicationContext,
                        TareaDatabase::class.java,
                        "tarea_database"
                    ).build()
                    INSTANCE=instace
                    return instace
                }
            }
        }
}