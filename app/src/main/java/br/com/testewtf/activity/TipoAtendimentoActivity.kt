package br.com.testewtf.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.testewtf.R
import br.com.testewtf.adapter.TipoAtendimentoAdapter
import br.com.testewtf.adapter.UsuarioAdapter
import br.com.testewtf.dialog.DialogTipoAtendimento
import br.com.testewtf.dialog.DialogUsuario
import br.com.testewtf.domain.TipoAtendimento
import br.com.testewtf.domain.Usuario
import br.com.testewtf.domain.dao.OnClickAdapter
import br.com.testewtf.domain.dao.ServiceTipoAtendimento
import br.com.testewtf.domain.dao.ServiceUsuario
import kotlinx.android.synthetic.main.activity_tipo_atendimento.*
import kotlinx.android.synthetic.main.activity_usuario.*
import kotlinx.android.synthetic.main.activity_usuario.label_msg
import kotlinx.android.synthetic.main.activity_usuario.recycler_view

class TipoAtendimentoActivity : AppCompatActivity(), OnClickAdapter<TipoAtendimento> {

    var tipos: List<TipoAtendimento> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tipo_atendimento)
        init()
    }

    fun init() {
        recycler_view?.layoutManager = LinearLayoutManager(this)
        recycler_view?.itemAnimator = DefaultItemAnimator()
        recycler_view?.setHasFixedSize(true)

        Thread(Runnable {
            tipos = ServiceTipoAtendimento.getTipoAtendimentos()
            runOnUiThread {

                if (tipos.isNotEmpty()) {
                    label_msg.visibility = View.GONE
                    recycler_view.adapter = TipoAtendimentoAdapter(tipos) {}
                }
            }
        }).start()

        fab_insert_tipo_atend.setOnClickListener {
            DialogTipoAtendimento.showDialog(supportFragmentManager, this)
        }
    }

    override fun onClick(tipoAtendimento: TipoAtendimento) {

        Thread(Runnable {
            ServiceTipoAtendimento.insert(tipoAtendimento)
            runOnUiThread {
                init()
            }
        }).start()
    }
}
