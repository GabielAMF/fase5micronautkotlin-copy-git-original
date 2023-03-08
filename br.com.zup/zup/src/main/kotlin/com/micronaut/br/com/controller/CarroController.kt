package com.micronaut.br.com.controller

import com.micronaut.br.com.model.dtoentrada.CarroDtoEntrada
import com.micronaut.br.com.repository.CarroRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/carro")
class CarroController (val carroRepository: CarroRepository){

    @Post
    @Transactional
    fun cadastrar(@Body @Valid request: CarroDtoEntrada): HttpResponse<String> {
        val novoCarro = request.paraCarro()
        carroRepository.save(novoCarro)
        return HttpResponse.ok()
    }
}