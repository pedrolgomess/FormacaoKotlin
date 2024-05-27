package br.com.alura.alugames.modelos.Gamer

import br.com.alura.alugames.modelos.Aluguel.Aluguel
import br.com.alura.alugames.modelos.Jogo.Jogo
import java.util.*
import kotlin.random.Random

data class Gamer(var nome: String, var email: String){
    var dataNascimento: String? = null
    var usuario: String? = null
        set(value) {
            field = value
            if(idInterno.isNullOrBlank()) {
                criarIdInterno()
            }
        }
    /*
    * O Kotlin implementa properties para administrar os atributos de uma classe.
    * Para deixarmos o valor de um atributo acessível fora da classe,
    * mas não permitirmos que ele seja modificado, deveríamos ter o seguinte código:
    * */
    var idInterno: String? = null //o atributo seja visualizado, porém, não seja alterado, apagamos o private.
        private set

    val jogosBuscados = mutableListOf<Jogo?>()
    //para que o construtor chame esta validação OU um bloco de código a ser executado antes da execução da classe
    init {
        if(nome.isNullOrBlank()){
            throw IllegalArgumentException("Nome está em branco")
        }
        this.email = validarEmail()
    }
    constructor(nome: String, email: String, dataNascimento: String, usuario: String): this(nome, email){
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()

    }

    override fun toString(): String {
        return "Gamer(" +
                "nome='$nome', " +
                "email='$email', " +
                "dataNascimento=$dataNascimento, " +
                "usuario=$usuario, " +
                "idInterno=$idInterno)"
    }
    fun criarIdInterno(){
        val numero = Random.nextInt()
        val tag = String.format("%04d", numero)
        idInterno = "$usuario#$tag"
    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if (regex.matches(email)){
            return email
        }else{
            throw IllegalArgumentException("Email inválido")
        }
    }
    companion object{
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao AluGames! Vamos fazer seu cadastro. Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("s", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            } else {
                return Gamer (nome, email)
            }
        }
    }
    fun alugaJogo(jogo: Jogo,): Aluguel{
        return Aluguel(this, jogo)
    }
}
