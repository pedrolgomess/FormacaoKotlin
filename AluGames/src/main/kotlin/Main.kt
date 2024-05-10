package org.example


import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

fun main() {
    val httpClient: HttpClient = HttpClient.newHttpClient()

    val request = HttpRequest.newBuilder().uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=146")).build()

    val response = httpClient.send(request, BodyHandlers.ofString())

    val json = response.body()

    val gson = Gson()

    val meujogo = gson.fromJson(json, InfoJogo::class.java)
    println(meujogo)

}