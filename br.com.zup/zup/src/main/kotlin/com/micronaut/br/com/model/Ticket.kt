package com.micronaut.br.com.model

import com.micronaut.br.com.enum.Status
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
@Entity
class Ticket(val titulo : String?,
             val descricao: String?,
             val dataCriacao: LocalDate?,
             val status: Status?) {

    @Id
    @GeneratedValue
    var id: Long? = null

}