package br.com.rafaelacioly.personagensmarvel.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import br.com.rafaelacioly.personagensmarvel.ui.mian.MainActivity
import br.com.rafaelacioly.personagensmarvel.BaseActivity

class SplashActivity : BaseActivity(){

    private val timeSleep: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        executionPause()
    }

    private fun executionPause(){
        //Pausa na execução
        Handler().postDelayed({
            //Abrindo a tela principal
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }, timeSleep)

    }

    override fun onStop() {
        super.onStop()
        //Tirando a tela do empilhamento
        finishAffinity()
    }
}