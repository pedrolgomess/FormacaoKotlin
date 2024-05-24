package br.com.alura.alugames.utils

import br.com.alura.alugames.modelos.Gamer.Gamer
import br.com.alura.alugames.modelos.Gamer.InfoGamer

fun InfoGamer.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}