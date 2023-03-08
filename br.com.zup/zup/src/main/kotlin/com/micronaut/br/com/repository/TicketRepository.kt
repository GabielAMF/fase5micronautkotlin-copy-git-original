package com.micronaut.br.com.repository

import com.micronaut.br.com.model.Ticket
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
@Repository
interface TicketRepository : JpaRepository<Ticket,Long> {
}