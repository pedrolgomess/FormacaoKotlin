package br.com.alura.alugames.utils

import br.com.alura.alugames.modelos.Jogo.InfoJogoJson
import br.com.alura.alugames.modelos.Jogo.Jogo

fun InfoJogoJson.criaJogo(): Jogo {
    return Jogo(this.titulo, this.capa, this.preco, this.descricao)
}