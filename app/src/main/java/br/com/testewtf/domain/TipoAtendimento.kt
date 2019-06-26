package br.com.testewtf.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tipo_atendimento")
class TipoAtendimento {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var descricao = ""
}