package br.com.souza.forum.services

import br.com.souza.forum.dto.AtualizacaoTopicoForm
import br.com.souza.forum.dto.NovoTopicoForm
import br.com.souza.forum.dto.TopicoView
import br.com.souza.forum.exception.NotFoundException
import br.com.souza.forum.mappers.TopicoFormMapper
import br.com.souza.forum.mappers.TopicoViewMapper
import br.com.souza.forum.models.Topico
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map { topico ->
            topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream()
            .filter { topico -> topico.id == id }
            .findFirst()
            .orElseThrow{NotFoundException(notFoundMessage)}

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)

        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos.stream()
            .filter { topico -> topico.id == form.id }
            .findFirst()
            .orElseThrow{NotFoundException(notFoundMessage)}
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            resposta = topico.resposta,
            status = topico.status,
            dataCriacao = topico.dataCriacao
        )
        topicos = topicos.minus(topico).plus(topicoAtualizado)
        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos.stream()
            .filter { topico -> topico.id == id }
            .findFirst()
            .orElseThrow{NotFoundException(notFoundMessage)}
        topicos = topicos.minus(topico)
    }
}