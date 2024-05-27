import br.com.alura.alugames.servicos.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()
    val listaJogosJson = consumo.buscaJogosJson()

    //println(listaGamers)
    //print(listaJogosJson)

    val jogador1 = listaGamers.get(3)
    val jogo1 = listaJogosJson.get(10)

    val jogoAlugado = jogador1.alugaJogo(jogo1)
    println(jogador1)
    print(jogo1)
    println(jogoAlugado)
}