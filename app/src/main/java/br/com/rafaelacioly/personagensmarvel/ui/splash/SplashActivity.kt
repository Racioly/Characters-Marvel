package br.com.rafaelacioly.personagensmarvel.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import br.com.rafaelacioly.personagensmarvel.ui.mian.MainActivity
import br.com.rafaelacioly.personagensmarvel.BaseActivity

class SplashActivity : BaseActivity(){

    private val timeSleep: Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        configScreen()
        executionPause()
    }

    private fun configScreen(){
        //Ocultando a barra de navegação
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
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