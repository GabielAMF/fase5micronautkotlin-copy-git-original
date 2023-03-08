package com.micronaut.br.com.validation

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FIELD,AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy =[UniqueGenericValidation::class])
annotation class UniqueGeneric(val message: String = "Campo deve ser único no banco",
                               val groups : Array<KClass<Any>> = [],
                               val payload: Array<KClass<Payload>> = [],
                               val campo : String,
                               val kclasse: KClass<out Any>)
