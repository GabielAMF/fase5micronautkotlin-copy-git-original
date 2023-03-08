package com.micronaut.br.com

import com.micronaut.br.com.model.Carro
import com.micronaut.br.com.repository.CarroRepository
import io.micronaut.test.annotation.TransactionMode
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test


@MicronautTest(
    rollback = false,
    transactionMode =  TransactionMode.SINGLE_TRANSACTION

)
class CarrosTest {

    @Inject
    lateinit var repository: CarroRepository

    @BeforeEach
    fun cleanDb(){
        repository.deleteAll()
    }
    @AfterEach
    fun eraseTest(){
        repository.deleteAll()
    }

    @Test
    fun `deve inserir um carro novo`(){
        //ação
        repository.save(Carro(placa = "ERZ1792",modelo =  "Fiat Uno"))
        //validação
        assertEquals(1,repository.count())

    }
    @Test
    fun `deve encontrar o carro por placa`(){
        repository.save(Carro(placa = "NAS5462",modelo =  "Fiat Duno"))
        assertTrue(repository.findByPlaca("NAS5462").isPresent)


    }
}