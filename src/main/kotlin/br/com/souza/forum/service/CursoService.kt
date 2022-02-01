package br.com.souza.forum.service

import br.com.souza.forum.model.Curso
import br.com.souza.forum.repository.CursoRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CursoService(private val repository: CursoRepository) {

    fun buscarPorId(id:Long): Curso {
        return repository.getById(id)
    }

}
