package br.com.rafaelacioly.personagensmarvel.model

data class Data(
    var offset  : Int? = null,
    var limit   : Int?              = null,
    var total   : Int?              = null,
    var count   : Int?              = null,
    var results : List<Character>? = null

    ){
    override fun toString(): String {
        return "$count"
    }
}