package br.com.souza.forum.services

import br.com.souza.forum.models.Curso
import br.com.souza.forum.models.Topico
import br.com.souza.forum.models.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class TopicoService(private var topicos: List<Topico>) {

    init {
        val topico = Topico(
            id = 1,
            titulo = "Duvida Kotlin",
            mensagem = "Variaveis Kotlin",
            curso = Curso(
                id = 1,
                nome = "Kotlin",
                categoria = "Programação"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "ana@gmail.com"
            )
        )

        val topico2 = Topico(
            id = 2,
            titulo = "Duvida Kotlin 2",
            mensagem = "Variaveis Kotlin 2",
            curso = Curso(
                id = 1,
                nome = "Kotlin 2",
                categoria = "Programação 2"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "ana@gmail.com"
            )
        )

        val topico3 = Topico(
            id = 3,
            titulo = "Duvida Kotlin 3",
            mensagem = "Variaveis Kotlin 3",
            curso = Curso(
                id = 1,
                nome = "Kotlin 3",
                categoria = "Programação 3"
            ),
            autor = Usuario(
                id = 1,
                nome = "Ana da Silva",
                email = "ana@gmail.com"
            )
        )

        topicos = Arrays.asList(topico, topico2, topico3)
    }

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos.stream()
            .filter({ topico -> topico.id == id })
            .findFirst()
            .get()
    }
}