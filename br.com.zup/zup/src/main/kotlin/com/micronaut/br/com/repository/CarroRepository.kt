package com.micronaut.br.com.repository

import com.micronaut.br.com.model.Carro
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface CarroRepository: JpaRepository<Carro,Long> {

    fun findByPlaca(placa: String): Optional<Carro>

}