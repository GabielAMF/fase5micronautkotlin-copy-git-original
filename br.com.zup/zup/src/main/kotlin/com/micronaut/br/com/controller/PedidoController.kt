package com.micronaut.br.com.controller

import com.micronaut.br.com.model.dtoentrada.PedidoDtoEntrada
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.transaction.Transactional

import javax.validation.Valid

@Validated
@Controller("/pedido")
class PedidoController {

    @Post
    @Transactional
    fun cadastrarPedido(@Body @Valid request: PedidoDtoEntrada) : HttpResponse<String> {
        println(request)

        val novoPedido = request.paraPedido()
        println(novoPedido.cliente.nome)
        println(novoPedido.cliente.email)
        println(novoPedido.total)
        for(item in novoPedido.itens){
            println(item.codigo)
            println(item.quantidade)
            println(item.preco)

        }

        return HttpResponse.ok()

    }

}