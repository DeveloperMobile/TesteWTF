package br.com.testewtf.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.testewtf.R
import br.com.testewtf.domain.TipoAtendimento
import br.com.testewtf.domain.Usuario
import kotlinx.android.synthetic.main.adapter_usuario.view.*

class TipoAtendimentoAdapter (val atendimentos: List<TipoAtendimento>, val onClick: (TipoAtendimento) -> Unit): RecyclerView.Adapter<TipoAtendimentoAdapter.TipoAtendimentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipoAtendimentoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_tipo_atendimento, parent, false)
        return TipoAtendimentoViewHolder(view)
    }

    override fun getItemCount(): Int = this.atendimentos.size

    override fun onBindViewHolder(holder: TipoAtendimentoViewHolder, position: Int) {
        val tipoAtendimento = atendimentos[position]
        val view = holder.itemView
        with(view) {
            nome.text = tipoAtendimento.descricao
            setOnClickListener { onClick(tipoAtendimento) }
        }
    }

    class TipoAtendimentoViewHolder(view: View) : RecyclerView.ViewHolder(view) {}

}