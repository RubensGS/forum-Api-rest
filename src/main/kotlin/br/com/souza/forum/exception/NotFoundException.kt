package br.com.souza.forum.exception

import java.lang.RuntimeException

class NotFoundException(message: String?): RuntimeException(message) {
}