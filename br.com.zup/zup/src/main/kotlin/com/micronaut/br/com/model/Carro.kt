package com.micronaut.br.com.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Carro(val placa: String?, val modelo: String? ) {

    @Id
    @GeneratedValue
    val id: Long? = null

}