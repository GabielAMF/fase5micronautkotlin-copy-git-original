package com.micronaut.br.com.client

import com.micronaut.br.com.client.Dtos.EnderecoResponse
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client


@Client("http://localhost:8081/cep/busca")
interface EnderecoClient {

    @Get
    fun consulta(@QueryValue cep: String) : HttpResponse<EnderecoResponse>
}