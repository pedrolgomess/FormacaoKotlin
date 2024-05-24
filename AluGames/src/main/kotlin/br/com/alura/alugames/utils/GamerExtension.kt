package br.com.alura.alugames.utils

import br.com.alura.alugames.modelos.Gamer.Gamer
import br.com.alura.alugames.modelos.Gamer.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(this.nome, this.email, this.dataNascimento, this.usuario)
}