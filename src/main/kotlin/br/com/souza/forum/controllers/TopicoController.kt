package br.com.souza.forum.controllers

import br.com.souza.forum.models.Topico
import br.com.souza.forum.services.TopicoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(): List<Topico> {
        return topicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico {
        return topicoService.buscarPorId(id)
    }

}