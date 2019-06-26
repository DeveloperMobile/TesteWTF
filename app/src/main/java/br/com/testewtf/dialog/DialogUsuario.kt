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
import br.com.testewtf.domain.Usuario
import br.com.testewtf.domain.dao.OnClickAdapter
import kotlinx.android.synthetic.main.dialog_usuario.*

class DialogUsuario() : DialogFragment() {

    var onClick: OnClickAdapter<Usuario>? = null

    companion object {
        fun showDialog(fm: FragmentManager, onClick: OnClickAdapter<Usuario>) {
            var ft: FragmentTransaction = fm.beginTransaction()
            var prev: Fragment? = fm.findFragmentByTag("usuario")

            if (prev != null) {
                ft.remove(prev)
            }

            ft.addToBackStack(null)
            var dialogUsuario: DialogUsuario = DialogUsuario()
            dialogUsuario.onClick = onClick
            dialogUsuario.show(ft, "usuario")
        }

        fun closeDialog(fm: FragmentManager) {
            var ft: FragmentTransaction = fm.beginTransaction()
            var dialogUsuario: DialogUsuario = fm.findFragmentByTag("usuario") as DialogUsuario

            if (dialogUsuario != null) {
                dialogUsuario.dismiss()
                ft.remove(dialogUsuario)
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder: AlertDialog.Builder = AlertDialog.Builder(requireActivity())

        var view = LayoutInflater.from(activity)?.inflate(R.layout.dialog_usuario, null)

        var nome = view?.findViewById<EditText>(R.id.et_nome)
        var tipo = view?.findViewById<Spinner>(R.id.sp_tipo)

        builder.setView(view)
            .setPositiveButton("Salvar", DialogInterface.OnClickListener { dialogInterface, i ->
                var usuario = Usuario()
                usuario.nome = nome?.text.toString()
                usuario.tipo = tipo?.selectedItem.toString()
                Log.d("Salvar", "Dados: ${nome?.text}. ${tipo?.selectedItem.toString()}")
                onClick?.onClick(usuario)
                Toast.makeText(activity, "Teste Salvar", Toast.LENGTH_SHORT).show()
            })
            .setNegativeButton("Cancelar", null)
        return builder.create()
    }

}