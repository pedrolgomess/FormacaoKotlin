package br.com.alura.alugames.modelos.Jogo

class Jogo(val titulo:String, val capa:String) {

    var descricao:String? = ""

    override fun toString(): String {
        return "Meu Jogo: \n" +
                "Título: $titulo \n" +
                "Capa: $capa \n" +
                "Descricao: $descricao"
    }


}