package com.micronaut.br.com.repository

import com.micronaut.br.com.model.Autor
import io.micronaut.data.annotation.Query
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.time.LocalDateTime
import java.util.*

@Repository
interface AutoRepository: JpaRepository<Autor,Long> {


    fun findByEmail(email : String): Optional<Autor>

    //fun findByClienteIdAndCriadaEmAfterOrderByCriadaEmDesc(clienteId : Long,criadaEm: LocalDateTime,pageable: Pageble): Optional<List<Any>>

    //@Query("SELECT nf FROM NotaFiscal nf LEFT JOIN nf.itens e where nf.id = :id")
    //fun encontrarTodasNotasEItens(id : Long) : Pageable<Any>

    @Query("SELECT a FROM Autor a WHERE a.email = :email")
    fun encontrarPorEmail(email: String) : Optional<Autor>

}