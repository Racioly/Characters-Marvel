package br.com.rafaelacioly.personagensmarvel.ui.details

import android.net.Uri
import android.os.Bundle
import br.com.rafaelacioly.personagensmarvel.BaseActivity
import br.com.rafaelacioly.personagensmarvel.R
import br.com.rafaelacioly.personagensmarvel.model.Character
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : BaseActivity(){

    lateinit var character: Character

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        getIntentParceble()
        bindView()
    }

    private fun getIntentParceble(){
        intent.getParcelableExtra<Character>("character")?.let {
            character = it
        }
    }

    private fun bindView(){
        txvName.text = character.name
        txvId.text = character.id.toString()
        txvDescription.text = if (character.description!!.isEmpty()) "No description" else character.description
        txvModified.text = character.modified
        imvThumb.setImageURI(Uri.parse(character.thumbnail.toString()),this@DetailsActivity)
    }
}