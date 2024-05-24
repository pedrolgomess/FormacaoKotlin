package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelos.Gamer.Gamer
import br.com.alura.alugames.modelos.Gamer.InfoGamer
import br.com.alura.alugames.utils.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GamerService {

    fun buscaGamer(): List<Gamer> {

        val json = consultaDados("https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json")

        val gson = Gson()

        val tipoRetorno = object : TypeToken<List<InfoGamer>>() {}.type
        val listGamer:List<InfoGamer> = gson.fromJson(json, tipoRetorno)

        val listaConvertida = listGamer.map { infoGamerJson -> infoGamerJson.criaGamer() }
        return listaConvertida;
    }
    // retornando Json da api
    fun consultaDados(endereco: String) : String{

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }
}