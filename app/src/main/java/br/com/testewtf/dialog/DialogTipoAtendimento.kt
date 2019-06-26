package br.com.testewtf.dialog

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import br.com.testewtf.R
import br.com.testewtf.domain.TipoAtendimento
import br.com.testewtf.domain.Usuario
import br.com.testewtf.domain.dao.OnClickAdapter
import kotlinx.android.synthetic.main.dialog_usuario.*

class DialogTipoAtendimento() : DialogFragment() {

    var onClick: OnClickAdapter<TipoAtendimento>? = null

    companion object {
        fun showDialog(fm: FragmentManager, onClick: OnClickAdapter<TipoAtendimento>) {
            var ft: FragmentTransaction = fm.beginTransaction()
            var prev: Fragment? = fm.findFragmentByTag("tipo_atendimento")

            if (prev != null) {
                ft.remove(prev)
            }

            ft.addToBackStack(null)
            var dialogTipoAtendimento: DialogTipoAtendimento = DialogTipoAtendimento()
            dialogTipoAtendimento.onClick = onClick
            dialogTipoAtendimento.show(ft, "tipo_atendimento")
        }

        fun closeDialog(fm: FragmentManager) {
            var ft: FragmentTransaction = fm.beginTransaction()
            var dialogTipoAtendimento: DialogTipoAtendimento = fm.findFragmentByTag("tipo_atendimento") as DialogTipoAtendimento

            if (dialogTipoAtendimento != null) {
                dialogTipoAtendimento.dismiss()
                ft.remove(dialogTipoAtendimento)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        var view = LayoutInflater.from(activity)?.inflate(R.layout.dialog_tipo_atendimento, null)

        var nome = view?.findViewById<EditText>(R.id.et_nome)

        builder.setView(view)
            .setPositiveButton("Salvar", DialogInterface.OnClickListener { dialogInterface, i ->
                var tipoAtendimento = TipoAtendimento()
                tipoAtendimento.descricao = nome?.text.toString()
                onClick?.onClick(tipoAtendimento)
                Toast.makeText(activity, "Teste Salvar", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Cancelar", null)
        return builder.create()
    }

}