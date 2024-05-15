package br.com.alura.alugames.principal

import br.com.alura.alugames.modelos.Jogo.Jogo
import br.com.alura.alugames.servicos.ConsumoApi

import java.util.Scanner

fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar:")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val informacaoJogo = buscaApi.buscaJogo(busca)


    var meuJogo: Jogo? = null

    val resultado = runCatching {
        meuJogo = Jogo(
            informacaoJogo.info.title,
            informacaoJogo.info.thumb
        )
    }
}