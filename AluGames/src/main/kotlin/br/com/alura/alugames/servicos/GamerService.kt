package br.com.alura.alugames.servicos

import br.com.alura.alugames.modelos.Gamer.InfoGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class GamerService {

    fun buscaGamer(): List<InfoGamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        // Para informarmos para o JSON qual o tipo que queremos receber, podemos usar um objeto do próprio JSON, o TypeToken.
        // Ele nos permite informar o tipo que queremos retornar na conversão do JSON e permite a identificação desse tipo.
        // precisamos passar o método que fará o JSON identificar esse tipo. Para isso, abrimos o escopo usando as chaves ({}) e escrevemos .type.
        // O .type será o responsável por passar para o JSON qual o tipo que queremos receber.

        val tipoRetorno = object : TypeToken<List<InfoGamer>>() {}.type
        val listGamer:List<InfoGamer> = gson.fromJson(json, tipoRetorno)

        return listGamer
    }
}