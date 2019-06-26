package br.com.testewtf.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.testewtf.R
import br.com.testewtf.adapter.UsuarioAdapter
import br.com.testewtf.dialog.DialogUsuario
import br.com.testewtf.domain.Usuario
import br.com.testewtf.domain.dao.OnClickAdapter
import br.com.testewtf.domain.dao.ServiceUsuario
import kotlinx.android.synthetic.main.activity_usuario.*


class UsuarioActivity : AppCompatActivity(), OnClickAdapter<Usuario> {

    var usuarios: List<Usuario> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)
        init()
    }

    fun init() {
        recycler_view?.layoutManager = LinearLayoutManager(this)
        recycler_view?.itemAnimator = DefaultItemAnimator()
        recycler_view?.setHasFixedSize(true)

        Thread(Runnable {
            usuarios = ServiceUsuario.getUsuarios()
            runOnUiThread {

                if (usuarios.isNotEmpty()) {
                    label_msg.visibility = View.GONE
                    recycler_view.adapter = UsuarioAdapter(usuarios) {}
                }
            }
        }).start()

        fab_insert_usuario.setOnClickListener {
            DialogUsuario.showDialog(supportFragmentManager, this)
        }
    }

    override fun onClick(usuario: Usuario) {

        Thread(Runnable {
            ServiceUsuario.insert(usuario)
            runOnUiThread {
                init()
            }
        }).start()
    }
}
