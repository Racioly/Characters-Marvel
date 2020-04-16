package br.com.rafaelacioly.personagensmarvel.network

import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitConfig {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://gateway.marvel.com/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    fun characterService() = retrofit.create(CharacterService::class.java)
}