package com.micronaut.br.com.model.dtoentrada

import io.micronaut.core.annotation.Introspected
import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Positive


@Introspected
data class ItemPedidoDtoEntrada ( @field : NotBlank val codigo: String
                            , @field:NotNull @field:Positive val preco: BigDecimal
                            ,@field: NotNull @field: Min(1) val quantidade : Int) {

}