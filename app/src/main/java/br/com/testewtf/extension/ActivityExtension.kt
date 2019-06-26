package br.com.testewtf.extension

import android.app.Activity
import android.widget.Toast

fun Activity.toast(msg: CharSequence, time: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, msg, time).show()