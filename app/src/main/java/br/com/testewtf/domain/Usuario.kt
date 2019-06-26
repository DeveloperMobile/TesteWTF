package br.com.testewtf.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
class Usuario {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var nome: String = ""
    var tipo: String = ""
}