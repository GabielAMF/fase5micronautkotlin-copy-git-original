package com.micronaut.br.com

import com.micronaut.br.com.model.Autor
import com.micronaut.br.com.model.dtoentrada.AutorDtoEntrada
import com.micronaut.br.com.model.dtoentrada.NovoAutorRequest
import com.micronaut.br.com.repository.AutoRepository
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull


@MicronautTest
class TesteControllerAutores {

    @field: Inject
    lateinit var autorRepository: AutoRepository

    @field: Inject
    @field: Client("/")
    lateinit var client: HttpClient

    lateinit var autor: Autor

    @BeforeEach
    internal fun setup(){
        autor = Autor(nome = "Autor do Teste", email = "email@doteste",descricao = "nossa que teste funcional")
        autorRepository.save(autor)
    }

    @AfterEach
    internal fun rollback(){
        autorRepository.deleteAll()
    }

    @Test
    internal fun `deve achar um autor`(){
        val response = client.toBlocking().exchange("/autor?email=${autor.email}",NovoAutorRequest::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())
        assertEquals(autor.nome, response.body()!!.nome)
        assertEquals(autor.email, response.body()!!.email)
        assertEquals(autor.descricao, response.body()!!.descricao)

    }
}