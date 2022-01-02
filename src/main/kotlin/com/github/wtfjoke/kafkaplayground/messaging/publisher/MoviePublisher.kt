package com.github.wtfjoke.kafkaplayground.messaging.publisher

import com.github.wtfjoke.kafkaplayground.data.Movie
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class MoviePublisher(
    private val moviePublishTemplate: KafkaTemplate<String, Movie>,
    @Value("\${movie.topic}")
    private val topic: String,
) {

    fun publishMovie(movieToPublish: Movie) {
        moviePublishTemplate.send(topic, movieToPublish.title, movieToPublish)
        println("Published ${movieToPublish.title} to $topic")
    }
}