package com.micronaut.br.com.model.dtoentrada

import com.fasterxml.jackson.annotation.JsonFormat
import com.micronaut.br.com.enum.Status
import com.micronaut.br.com.model.Ticket
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate

import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class TickerDtoEntrada(@field: NotBlank @field: Size(max=60) val titulo: String,
                            @field: NotBlank @field: Size(max=4000)val descricao:String,
                            //@field: JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
                            val dataCriacao: LocalDate,
                            ){

    fun paraTicker(): Ticket {
        return Ticket(titulo = this.titulo,descricao = this.descricao, dataCriacao = this.dataCriacao, status = Status.ABERTO)
    }

}
