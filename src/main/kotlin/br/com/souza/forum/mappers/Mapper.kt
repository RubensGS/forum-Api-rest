package br.com.souza.forum.mappers

interface Mapper<T, U> {

    fun map(t:T): U

}
