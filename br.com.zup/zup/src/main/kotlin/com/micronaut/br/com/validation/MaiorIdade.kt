package com.micronaut.br.com.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass


@MustBeDocumented
@Target(AnnotationTarget.FIELD,AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy =[MaiorIdadeValidation::class])
annotation class MaiorIdade(val message: String = "Campo deve ser maior de Idade",
                            val groups : Array<KClass<Any>> = [],
                            val payload: Array<KClass<Payload>> = [])
