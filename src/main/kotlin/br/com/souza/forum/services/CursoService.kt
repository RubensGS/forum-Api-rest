package br.com.souza.forum.services

import br.com.souza.forum.models.Curso
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Stream

@Service
class CursoService(var cursos: List<Curso>) {

      init {
          val curso = Curso(
              id = 1,
              nome = "Kotlin",
              categoria = "Programação"
          )
          cursos = Arrays.asList(curso)
      }

    fun buscarPorId(id:Long): Curso {
        return cursos.stream()
            .filter { curso -> curso.id == id  }
            .findFirst()
            .get()
    }

}
