package com.micronaut.br.com.model.dtoentrada

import com.micronaut.br.com.validation.MaiorIdade
import io.micronaut.core.annotation.Introspected
import java.time.LocalDate
import javax.validation.constraints.*

@Introspected
data class ClienteDtoEntrada(@field: NotBlank @field: Size(max = 120) val nome: String,
                             @field:NotBlank @field: Email val email: String,
                             @field: NotNull @field: Past @field: MaiorIdade val dataNascimento: LocalDate){

}
