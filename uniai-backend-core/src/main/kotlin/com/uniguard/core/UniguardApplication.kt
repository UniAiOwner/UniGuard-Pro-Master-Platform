package com.uniguard.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UniguardApplication

fun main(args: Array<String>) {
    runApplication<UniguardApplication>(*args)
}
