package br.com.souza.forum.dto

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import kotlin.math.min


data class NovoTopicoForm(
    @field:NotEmpty(message = "Título não pode ser em branco") @field:Size(min = 5, max = 100) val titulo: String,
    @field:NotEmpty(message = "Mensagem não pode ser em branco") val mensagem: String,
    @field:NotNull val idCurso: Long,
    @field:NotNull val idAutor: Long
)
