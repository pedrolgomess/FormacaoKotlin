package org.example


import com.google.gson.Gson
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

    val meuJogo = Jogo(meuInfoJogo.info.title, meuInfoJogo.info.thumb)

    println(meuJogo)

}