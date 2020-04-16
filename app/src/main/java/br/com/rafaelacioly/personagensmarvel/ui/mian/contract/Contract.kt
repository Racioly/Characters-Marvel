package br.com.rafaelacioly.personagensmarvel.ui.mian.contract

import br.com.rafaelacioly.personagensmarvel.model.Character

interface Contract {

    interface CharacterView{
        fun showError(error: String?)
        fun showCharacters(characters: List<Character>)
    }

    interface Presenter{
        fun getCharacters()
    }
}