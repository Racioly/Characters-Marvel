package br.com.rafaelacioly.personagensmarvel.ui.mian

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.rafaelacioly.personagensmarvel.BaseActivity
import br.com.rafaelacioly.personagensmarvel.R
import br.com.rafaelacioly.personagensmarvel.model.Character
import br.com.rafaelacioly.personagensmarvel.ui.mian.adapter.CharacterAdapter
import br.com.rafaelacioly.personagensmarvel.ui.mian.contract.Contract
import br.com.rafaelacioly.personagensmarvel.ui.mian.presenter.Presenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), Contract.CharacterView {

    private lateinit var presenter: Presenter
    private val context = this@MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        kProgressHUD?.show()
        presenter = Presenter(context)
        presenter.getCharacters()
    }

    override fun showError(error: String?) {
        showAlert("Ops...", "Connection error: could not connect to the server.")
        kProgressHUD?.dismiss()
    }

    override fun showCharacters(characters: List<Character>) {
        rcvCharacters.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = CharacterAdapter(context, characters)
        }
        kProgressHUD?.dismiss()
    }
}
