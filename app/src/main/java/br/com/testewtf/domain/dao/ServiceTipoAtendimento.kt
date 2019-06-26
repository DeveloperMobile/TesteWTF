package br.com.testewtf.domain.dao

import br.com.testewtf.domain.TipoAtendimento
import br.com.testewtf.domain.Usuario

object ServiceTipoAtendimento {
    fun getTipoAtendimentos(): List<TipoAtendimento> {
        val dao = DatabaseManager.getTipoAtendimentoDAO()
        return dao.findAll()
    }

    fun insert(tipoAtendimento: TipoAtendimento) {
        val dao = DatabaseManager.getTipoAtendimentoDAO()
        dao.insert(tipoAtendimento)
    }

    fun update(tipoAtendimento: TipoAtendimento) {
        val dao = DatabaseManager.getTipoAtendimentoDAO()
        dao.update(tipoAtendimento)
    }

    fun delete(tipoAtendimento: TipoAtendimento) {
        val dao = DatabaseManager.getTipoAtendimentoDAO()
        dao.delete(tipoAtendimento)
    }
}