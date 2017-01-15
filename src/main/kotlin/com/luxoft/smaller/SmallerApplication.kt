package com.luxoft.smaller

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class SmallerApplication

fun main(args: Array<String>) {
    SpringApplication.run(SmallerApplication::class.java, *args)
}
