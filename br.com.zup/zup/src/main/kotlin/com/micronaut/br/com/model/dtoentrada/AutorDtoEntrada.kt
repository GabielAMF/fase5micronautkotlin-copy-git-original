package com.micronaut.br.com.model.dtoentrada

import com.micronaut.br.com.model.Autor

data class  AutorDtoEntrada(val nome: String,
                            val email: String,
                            val  livro: LivroDtoEntrada)
{


}