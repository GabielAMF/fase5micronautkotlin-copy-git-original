package com.micronaut.br.com.model.dtoentrada

import com.micronaut.br.com.model.Autor
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected
data class  NovoAutorRequest(@field: NotBlank val nome: String,
                             @field: NotBlank @field: Email val email: String,
                             @field: NotBlank @field: Size(max=500) val  descricao: String)    {

    fun paraAutor(): Autor {
        return Autor(nome,email,descricao)
    }
}