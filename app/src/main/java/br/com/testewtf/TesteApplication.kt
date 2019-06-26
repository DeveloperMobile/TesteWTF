package br.com.testewtf

import android.app.Application
import android.util.Log
import androidx.room.Room
import br.com.testewtf.domain.dao.Database
import java.lang.IllegalStateException

class TesteApplication : Application() {
    private val TAG = "TesteApplication"

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {
        private var appInstance: TesteApplication? = null

        fun getInstance(): TesteApplication {
            if (appInstance == null) {
                throw IllegalStateException("Configura a classe de Application no AndroidManinfst.xml")
            }
            return appInstance!!
        }
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(TAG, "TesteApplication.onTerminate()/")
    }
}