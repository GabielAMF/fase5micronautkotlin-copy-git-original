package com.micronaut.br.com.controller

import com.micronaut.br.com.model.Autor
import com.micronaut.br.com.model.dtoentrada.AutorDtoEntrada
import com.micronaut.br.com.model.dtoentrada.AutorDtoSaida
import com.micronaut.br.com.model.dtoentrada.NovoAutorRequest
import com.micronaut.br.com.repository.AutoRepository
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import jakarta.inject.Inject
import java.util.*
import javax.transaction.Transactional
import javax.validation.Valid
import javax.validation.Validator

@Validated
@Controller("/autor")
class AutorController (val autorRepository: AutoRepository) {


    @Post
    @Transactional
    fun cadatra(@Body  request: NovoAutorRequest): HttpResponse<Any>{


        println(request)
        val autor: Autor = request.paraAutor()
        autorRepository.save(autor)
        println("Autor-> ${autor.nome}")
        val uri = UriBuilder.of("/autor/{id}").expand(mutableMapOf(Pair("id",autor.id)))
        return HttpResponse.created(uri)


    }
    @Get
    @Transactional
    fun lista(@QueryValue(defaultValue = "") email: String): HttpResponse<Any>{
        if(email.isBlank()) {
            val autores: List<Autor> = autorRepository.findAll()
            val listaDtoAutores: MutableList<AutorDtoSaida> = mutableListOf()
            for (autor in autores) {
                listaDtoAutores.add(AutorDtoSaida(autor))
            }
            return HttpResponse.ok(listaDtoAutores)
        }
        val autorOpt = autorRepository.encontrarPorEmail(email)
        if(autorOpt.isEmpty) return HttpResponse.notFound()
        val autor = autorOpt.get()
        return HttpResponse.ok(AutorDtoSaida(autor))
    }

    @Put("/{id}")
    @Transactional
    fun atualiza(@PathVariable id: Long, @Body @Valid request :NovoAutorRequest): HttpResponse<Any>{
        val autorOpt : Optional<Autor> = autorRepository.findById(id)
        if(autorOpt.isEmpty) return HttpResponse.notFound()
        val novoAutor = autorOpt.get()
        novoAutor.nome = request.nome
        novoAutor.descricao = request.descricao
        novoAutor.email = request.email

        return HttpResponse.ok(AutorDtoSaida(novoAutor))
    }

    @Delete("/{id}")
    @Transactional
    fun deletar(@PathVariable id:Long): HttpResponse<Any>{
        val autorOpt = autorRepository.findById(id)
        if(autorOpt.isEmpty) return HttpResponse.ok()
        autorRepository.deleteById(id)

        return HttpResponse.ok()
    }

}