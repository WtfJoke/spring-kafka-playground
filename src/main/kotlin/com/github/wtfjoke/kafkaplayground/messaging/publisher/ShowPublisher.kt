package com.github.wtfjoke.kafkaplayground.messaging.publisher

import com.github.wtfjoke.kafkaplayground.data.Show
import com.github.wtfjoke.kafkaplayground.messaging.config.TopicConfiguration
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class ShowPublisher(
    private val showPublisher: KafkaTemplate<String, Show>,
    private val topics: TopicConfiguration
) {

    fun publishShow(showToPublish: Show) {
        showPublisher.send(topics.show, showToPublish.title, showToPublish)
        println("Published ${showToPublish.title} to ${topics.show}")
    }
}