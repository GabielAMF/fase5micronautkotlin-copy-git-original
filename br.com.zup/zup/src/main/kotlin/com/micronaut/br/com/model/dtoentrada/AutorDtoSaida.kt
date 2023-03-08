package com.micronaut.br.com.model.dtoentrada

import com.micronaut.br.com.model.Autor

class AutorDtoSaida(autor: Autor) {

    val nome = autor.nome
    val email = autor.email
    val descricao = autor.descricao

}