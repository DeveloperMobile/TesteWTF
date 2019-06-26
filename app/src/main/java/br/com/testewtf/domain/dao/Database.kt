package br.com.testewtf.domain.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.testewtf.domain.TipoAtendimento
import br.com.testewtf.domain.Usuario

@Database(entities = [Usuario::class, TipoAtendimento::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun tipoAtendimentoDAO(): TipoAtendimentoDAO
}