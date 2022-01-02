package com.github.wtfjoke.kafkaplayground.messaging

import com.github.wtfjoke.kafkaplayground.testcontainers.StartKafkaContainerBeforeAllExtension
import org.junit.jupiter.api.Test

class ConfluentContainerStartupTest {

    @Test
    fun containerStarted(){
        StartKafkaContainerBeforeAllExtension.kafkaContainer.start()
        StartKafkaContainerBeforeAllExtension.schemaRegistryContainer.start()
    }
}