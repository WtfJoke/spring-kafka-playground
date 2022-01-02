package com.github.wtfjoke.kafkaplayground.messaging.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "topics")
data class TopicConfiguration(val movie: String, val show: String)