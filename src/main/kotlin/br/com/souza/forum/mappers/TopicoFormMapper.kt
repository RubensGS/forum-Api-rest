package br.com.souza.forum.mappers

import br.com.souza.forum.dto.NovoTopicoForm
import br.com.souza.forum.models.Topico
import br.com.souza.forum.services.CursoService
import br.com.souza.forum.services.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) : Mapper<NovoTopicoForm, Topico> {

    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
            titulo = t.titulo,
            mensagem = t.mensagem,
            curso = cursoService.buscarPorId(t.idCurso),
            autor = usuarioService.buscarPorId(t.idAutor),
        )
    }
}
