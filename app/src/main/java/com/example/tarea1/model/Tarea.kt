package com.example.tarea1.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="tarea")
data class Tarea(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="cancion")
    val Cancion:String,
    @ColumnInfo(name="artista")
    val Artista:String,
    @ColumnInfo(name="album")
    val Album:String,
    @ColumnInfo(name="año")
    val year:String,
    @ColumnInfo(name="rutaAudio")
    val rutaAudio:String,
    @ColumnInfo(name="rutaImagen")
    val rutaImagen:String,

) : Parcelable