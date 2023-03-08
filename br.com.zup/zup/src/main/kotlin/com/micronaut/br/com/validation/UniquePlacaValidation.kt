package com.micronaut.br.com.validation

import com.micronaut.br.com.repository.CarroRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton
import javax.validation.Constraint
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import javax.validation.Payload
import kotlin.reflect.KClass

@MustBeDocumented
@Target(AnnotationTarget.FIELD,AnnotationTarget.CONSTRUCTOR)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy =[UniquePlacaValidation::class])
annotation class UniquePlaca(
    val message: String = "Placa deve ser única",
    val groups : Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = []



)

@Singleton
class UniquePlacaValidation : ConstraintValidator<UniquePlaca,String> {
    @Inject
    lateinit var carroRepository: CarroRepository


    override fun initialize(constraintAnnotation: UniquePlaca?) {

        super.initialize(constraintAnnotation)
    }

    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {

        val optCarro = carroRepository.findByPlaca(value ?: return false)
        if (optCarro.isEmpty()) return true
        return false
    }


}