package com.micronaut.br.com.model.dtoentrada

import com.micronaut.br.com.model.Carro
import com.micronaut.br.com.validation.UniqueGeneric
import com.micronaut.br.com.validation.UniquePlaca
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

@Introspected
data class CarroDtoEntrada(@field: UniqueGeneric(campo = "placa",kclasse = Carro::class)  @field: Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}") val placa: String,
                           @field: NotBlank @Size(max = 60) val modelo: String){


    fun paraCarro(): Carro {
        return Carro(placa = this.placa, modelo = this.modelo)
    }
}
