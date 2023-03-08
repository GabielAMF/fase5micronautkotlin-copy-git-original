package com.micronaut.br.com.model.dtoentrada

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.*
import kotlin.math.max

@Introspected
data class AlunoDtoEntrada(@field : NotBlank  @field: Size(max = 60)  val nome:String,
                           @field : Email @field: NotBlank val email:String
                           , @field: NotNull @field: Min(18) val idade: Int) {
}