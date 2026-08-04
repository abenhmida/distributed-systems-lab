package com.krizaldis.distributedsystem.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["com.krizaldis.distributedsystem"])
@EnableJpaRepositories
class OrderServiceApplication {
}

fun main(args: Array<String>) {
    runApplication<OrderServiceApplication>(*args)
}