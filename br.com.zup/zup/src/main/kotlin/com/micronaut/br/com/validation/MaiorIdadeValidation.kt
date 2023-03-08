package com.micronaut.br.com.validation

import jakarta.inject.Singleton
import java.time.LocalDate
import javax.validation.ConstraintValidator
import javax.validation.ConstraintValidatorContext

@Singleton
class MaiorIdadeValidation: ConstraintValidator<MaiorIdade, LocalDate> {
    override fun isValid(value: LocalDate?, context: ConstraintValidatorContext?): Boolean {
        if( value == null) return true
        var agora: LocalDate = LocalDate.now()
        var dezoitoAtras = agora.minusYears(18)
        return (value <= dezoitoAtras)

    }
}