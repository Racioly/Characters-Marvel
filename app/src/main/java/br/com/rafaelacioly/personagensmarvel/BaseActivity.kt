package br.com.rafaelacioly.personagensmarvel

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.kaopiz.kprogresshud.KProgressHUD
open class BaseActivity : AppCompatActivity(){

    /**Barra de progresso*/
    var kProgressHUD: KProgressHUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //Instanciando barra de progresso
        kProgressHUD = KProgressHUD.create(this@BaseActivity)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setLabel(getString(R.string.text_processing))
            .setCancellable(false)
            .setAnimationSpeed(2)
            .setDimAmount(0.7f)
        super.onCreate(savedInstanceState)
    }

    /**Função para menssagens via Alert com um único botão*/
    fun showAlert(title: String, message: String, onClick: DialogInterface.OnClickListener){
        AlertDialog.Builder(this@BaseActivity)
            .setCancelable(false)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.text_ok), onClick)
            .create()
            .show()
    }

}