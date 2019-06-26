package br.com.testewtf.domain.dao

import androidx.room.*
import br.com.testewtf.domain.TipoAtendimento

@Dao
interface TipoAtendimentoDAO {
    @Query("SELECT * FROM tipo_atendimento")
    fun findAll(): List<TipoAtendimento>
    @Insert
    fun insert(usuario: TipoAtendimento)
    @Update
    fun update(usuario: TipoAtendimento)
    @Delete
    fun delete(usuario: TipoAtendimento)
}