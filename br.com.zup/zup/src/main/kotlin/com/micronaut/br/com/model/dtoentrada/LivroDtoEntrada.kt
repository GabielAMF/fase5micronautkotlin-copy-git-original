package com.micronaut.br.com.model.dtoentrada

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import java.util.*

data class LivroDtoEntrada(val titulo:String
                            ,val isbn:String
                           , @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING) val dataPublicacao: Date)                           {
}