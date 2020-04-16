package br.com.rafaelacioly.personagensmarvel.network

import br.com.rafaelacioly.personagensmarvel.model.ResponseAPI
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterService {

    @GET("v1/public/characters?limit=100&ts=1&apikey=bf0a75e351a5cfed0d01dc5ec3f9cf3a&hash=f68ee1ad0306861ac1114a797d4f98a3")
    fun getCharacter(): Call<ResponseAPI>
}