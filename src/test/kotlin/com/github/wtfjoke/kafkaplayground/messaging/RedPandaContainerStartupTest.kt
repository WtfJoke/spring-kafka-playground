package com.github.wtfjoke.kafkaplayground.messaging

import com.github.wtfjoke.kafkaplayground.testcontainers.StartRedPandaBeforeAllExtension
import org.junit.jupiter.api.Test

class RedPandaContainerStartupTest {

    @Test
    fun containerStarted(){
        StartRedPandaBeforeAllExtension.kafkaContainer.start()
    }
}