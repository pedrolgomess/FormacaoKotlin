


import com.google.gson.Gson
import org.example.InfoJogo
import org.example.Jogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)

    println("DIGITE UM CÓDIGO DE JOGO PARA BUSCAR: ")
    val busca = leitura.nextLine()
    val httpClient: HttpClient = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder().uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$busca")).build()

    val response = httpClient.send(request, BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()

    val meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

    var meuJogo: Jogo? = null //meuJogo do tipo Jogo recebendo nulo

    val resultado = runCatching {
         meuJogo = Jogo(
            meuInfoJogo.info.title,
            meuInfoJogo.info.thumb
        )
        println(meuJogo)
    }
    resultado.onFailure {
        println("Jogo inexistente, tente outro id")
    }
    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada ? S/N")
        val opcao = leitura.nextLine()
        if (opcao.equals("S", true)){
            println("Insira a descrição personalizada para o Jogo:")
            val descricaoPersonalizada = leitura.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        }else{
            meuJogo?.descricao = meuJogo?.titulo
        }
    }
}