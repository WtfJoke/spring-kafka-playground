package com.github.wtfjoke.kafkaplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class SpringKafkaPlaygroundApplication

fun main(args: Array<String>) {
	runApplication<SpringKafkaPlaygroundApplication>(*args)
}
