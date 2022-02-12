package br.com.souza.forum.service

import br.com.souza.forum.dto.AtualizacaoTopicoForm
import br.com.souza.forum.dto.NovoTopicoForm
import br.com.souza.forum.dto.TopicoView
import br.com.souza.forum.exception.NotFoundException
import br.com.souza.forum.mapper.TopicoFormMapper
import br.com.souza.forum.mapper.TopicoViewMapper
import br.com.souza.forum.model.Topico
import br.com.souza.forum.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors
import kotlin.collections.ArrayList

@Service
class TopicoService(
    private val repository: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Topico não encontrado!"
) {

    fun listar(nomeCurso: String?): List<TopicoView> {
        val topicos = if (nomeCurso == null) {
            repository.findAll()
        } else {
            repository.findByCursoNome(nomeCurso)
        }
        return repository.findAll().stream().map { topico ->
            topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repository.findById(id)
            .orElseThrow{NotFoundException(notFoundMessage)}
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        val topico = topicoFormMapper.map(form)
        repository.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = repository.findById(form.id)
            .orElseThrow{NotFoundException(notFoundMessage)}

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }
}