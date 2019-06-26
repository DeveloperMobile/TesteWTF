package br.com.testewtf.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.testewtf.R
import br.com.testewtf.extension.toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        cadastroAtendimento.setOnClickListener { toast("Registro de Atendimentos") }
        cadastroTipoAtend.setOnClickListener {
            startActivity(Intent(this, TipoAtendimentoActivity::class.java))
        }
        cadastroTecnico.setOnClickListener {
            startActivity(Intent(this, UsuarioActivity::class.java))
        }
    }
}
