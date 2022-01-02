package com.github.wtfjoke.kafkaplayground.messaging.publisher

import com.github.wtfjoke.kafkaplayground.data.Movie
import com.github.wtfjoke.kafkaplayground.messaging.config.TopicConfiguration
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class MoviePublisher(
    private val moviePublishTemplate: KafkaTemplate<String, Movie>,
    private val topics: TopicConfiguration
) {

    fun publishMovie(movieToPublish: Movie) {
        moviePublishTemplate.send(topics.movie, movieToPublish.title, movieToPublish)
        println("Published ${movieToPublish.title} to ${topics.movie}")
    }
}