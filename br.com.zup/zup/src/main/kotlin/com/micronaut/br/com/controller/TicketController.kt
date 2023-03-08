package com.micronaut.br.com.controller

import com.micronaut.br.com.model.Ticket
import com.micronaut.br.com.model.dtoentrada.TickerDtoEntrada
import com.micronaut.br.com.repository.TicketRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.transaction.Transactional

import javax.validation.Valid

@Validated
@Controller("/ticket")
class TicketController(val ticketRepository: TicketRepository) {
    @Post
    @Transactional
    fun cadastrar(@Body @Valid request: TickerDtoEntrada): HttpResponse<String> {
        val novoTicket : Ticket = request.paraTicker()
        ticketRepository.save(novoTicket)
        println("id : ->${novoTicket.id}")
        return HttpResponse.ok()
    }

}