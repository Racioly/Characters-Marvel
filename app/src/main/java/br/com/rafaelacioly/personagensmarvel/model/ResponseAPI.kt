package br.com.rafaelacioly.personagensmarvel.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(value = ["attributionText", "attributionHTML", "etag"])
data class ResponseAPI(
    var code        : Int?      = null,
    var status      : String?   = null,
    var copyright   : String?   = null,
    var data        : Data?     = null
){
    override fun toString(): String {
        return "$code"
    }
}