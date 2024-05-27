package br.com.alura.alugames.modelos.Aluguel

import br.com.alura.alugames.modelos.Gamer.Gamer
import br.com.alura.alugames.modelos.Jogo.Jogo

data class Aluguel(
    val gamer: Gamer,
    val jogo: Jogo,

) {
    override fun toString(): String {
        return "O aluguel do jogo: ${jogo.titulo}, foi feito por: ${gamer.nome}"
    }
}
