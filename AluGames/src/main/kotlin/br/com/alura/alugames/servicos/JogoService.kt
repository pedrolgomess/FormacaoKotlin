package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelos.Jogo.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class JogoService {

    fun buscaJogo(id:String): InfoJogo {

        val json = consomeDados("https://www.cheapshark.com/api/1.0/games?id=$id")

        val gson = Gson()
        val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }
    // Consumindo dados da api
    fun consomeDados(endereco: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        return client.send(request, HttpResponse.BodyHandlers.ofString()).body()
    }

}