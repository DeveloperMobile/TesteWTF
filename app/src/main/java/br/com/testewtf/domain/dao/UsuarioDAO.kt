package br.com.testewtf.domain.dao

import androidx.room.*
import br.com.testewtf.domain.Usuario

@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM usuario")
    fun findAll(): List<Usuario>
    @Insert
    fun insert(usuario: Usuario)
    @Update
    fun update(usuario: Usuario)
    @Delete
    fun delete(usuario: Usuario)
}