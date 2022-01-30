package br.com.souza.forum.services

import br.com.souza.forum.dto.NovoTopicoForm
import br.com.souza.forum.dto.TopicoView
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
    private val topicoFormMapper: TopicoFormMapper
    ) {

    fun listar(): List<TopicoView> {
        return topicos.stream().map {
                topico -> topicoViewMapper.map(topico)
        }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos.stream()
            .filter { topico -> topico.id == id }
            .findFirst()
            .get()

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm) {
        val topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
    }
}