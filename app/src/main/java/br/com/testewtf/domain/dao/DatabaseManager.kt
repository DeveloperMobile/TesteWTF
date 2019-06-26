package br.com.testewtf.domain.dao

import androidx.room.Room
import br.com.testewtf.TesteApplication

object DatabaseManager {
    private var dbInstance: Database
    init {
        val appContext = TesteApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            Database::class.java,
            "atendimentos.sqlite")
            .build()
    }

    fun getUsuarioDAO(): UsuarioDAO {
        return dbInstance.usuarioDAO()
    }

    fun  getTipoAtendimentoDAO(): TipoAtendimentoDAO {
        return dbInstance.tipoAtendimentoDAO()
    }
}