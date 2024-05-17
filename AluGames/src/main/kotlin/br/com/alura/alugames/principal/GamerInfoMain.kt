package br.com.alura.alugames.principal

import br.com.alura.alugames.servicos.GamerService

fun main(){
    val rest = GamerService()
    val lista = rest.buscaGamer()
    println(lista)
}