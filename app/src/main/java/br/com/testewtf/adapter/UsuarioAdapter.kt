package br.com.testewtf.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.testewtf.R
import br.com.testewtf.domain.Usuario
import kotlinx.android.synthetic.main.adapter_usuario.view.*

class UsuarioAdapter (val usuarios: List<Usuario>, val onClick: (Usuario) -> Unit): RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_usuario, parent, false)
        return UsuarioViewHolder(view)
    }

    override fun getItemCount(): Int = this.usuarios.size

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = usuarios[position]
        val view = holder.itemView
        with(view) {
            nome.text = usuario.nome
            tipo.text = usuario.tipo
            setOnClickListener { onClick(usuario) }
        }
    }

    class UsuarioViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

}