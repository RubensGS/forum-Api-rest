package br.com.souza.forum.controllers

import br.com.souza.forum.dto.NovoTopicoForm
import br.com.souza.forum.dto.TopicoView
import br.com.souza.forum.services.TopicoService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/topicos")
class TopicoController(private val topicoService: TopicoService) {

    @GetMapping
    fun listar(): List<TopicoView> {
        return topicoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): TopicoView {
        return topicoService.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid topico: NovoTopicoForm) {
        topicoService.cadastrar(topico)
    }

}