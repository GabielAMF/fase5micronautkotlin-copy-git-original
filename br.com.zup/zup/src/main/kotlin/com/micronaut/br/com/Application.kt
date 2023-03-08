package com.micronaut.br.com

import io.micronaut.runtime.Micronaut.*
fun main(args: Array<String>) {
	build()
	    .args(*args)
		.packages("com.micronaut.br.com")
		.start()
}

