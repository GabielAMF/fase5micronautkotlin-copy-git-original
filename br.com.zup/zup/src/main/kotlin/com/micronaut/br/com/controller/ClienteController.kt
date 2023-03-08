package com.micronaut.br.com.controller

import com.micronaut.br.com.model.dtoentrada.ClienteDtoEntrada
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Validated
@Controller("/cliente")
class ClienteController {
    @Post
    fun testeCliente (@Body @Valid request: ClienteDtoEntrada): HttpResponse<Any>{
        return HttpResponse.ok()
    }


}