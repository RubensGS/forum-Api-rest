package br.com.souza.forum.mappers

import br.com.souza.forum.dto.TopicoView
import br.com.souza.forum.models.Topico
import org.springframework.stereotype.Component

@Component
class TopicoViewMapper: Mapper<Topico, TopicoView> {

    override fun map(t: Topico): TopicoView {
        return TopicoView(
            id = t.id,
            titulo = t.titulo,
            mensagem = t.mensagem,
            dataCriacao = t.dataCriacao,
            status = t.status)
    }
}