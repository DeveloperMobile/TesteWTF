package br.com.testewtf.domain.dao

import br.com.testewtf.domain.Usuario

object ServiceUsuario {
    fun getUsuarios(): List<Usuario> {
        val dao = DatabaseManager.getUsuarioDAO()
        return dao.findAll()
    }

    fun insert(usuario: Usuario) {
        val dao = DatabaseManager.getUsuarioDAO()
        dao.insert(usuario)
    }

    fun update(usuario: Usuario) {
        val dao = DatabaseManager.getUsuarioDAO()
        dao.update(usuario)
    }

    fun delete(usuario: Usuario) {
        val dao = DatabaseManager.getUsuarioDAO()
        dao.delete(usuario)
    }

}