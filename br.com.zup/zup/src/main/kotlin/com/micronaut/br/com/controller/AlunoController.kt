package com.micronaut.br.com.controller

import com.micronaut.br.com.model.dtoentrada.AlunoDtoEntrada
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject
import javax.transaction.Transactional

import javax.validation.Validator

@Controller("/aluno")
class AlunoController {
    @Inject
    lateinit var validator: Validator

    @Post
    @Transactional
    fun cadastra(@Body request: AlunoDtoEntrada): HttpResponse<String> {
        val constraintViolation = validator.validate(request);

        println(constraintViolation.first().message)

        if(constraintViolation.size>0){
            return HttpResponse.badRequest(constraintViolation.first().message)
        }
            println(request)
            return     HttpResponse.ok()


    }

}