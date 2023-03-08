package com.micronaut.br.com.validation

import jakarta.inject.Singleton
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query
import javax.transaction.Transactional
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext
import kotlin.reflect.KClass


@Singleton
open class UniqueGenericValidation : ConstraintValidator<UniqueGeneric,String> {
    @PersistenceContext
    private  lateinit var em: EntityManager
    private lateinit var campo: String
    private lateinit var classe: KClass<out Any>


    override fun initialize(constraintAnnotation: UniqueGeneric?) {
        this.classe = constraintAnnotation?.kclasse!!
        this.campo = constraintAnnotation.campo

    }
    @Transactional
    override fun isValid(value: String?, context: ConstraintValidatorContext?): Boolean {
        if (value == null) return  false
        val query = em.createQuery("select a FROM ${classe.simpleName} a where ${campo} = :value")
        query.setParameter("value",value)
        val resultado = query.resultList
        return resultado.isEmpty()
    }
}