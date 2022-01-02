package com.github.wtfjoke.kafkaplayground.web

import com.github.wtfjoke.kafkaplayground.data.Movie
import com.github.wtfjoke.kafkaplayground.data.Show
import com.github.wtfjoke.kafkaplayground.messaging.publisher.MoviePublisher
import com.github.wtfjoke.kafkaplayground.messaging.publisher.ShowPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VideoRestController(
    val moviePublisher: MoviePublisher,
    val showPublisher: ShowPublisher
) {

    val movies = listOf(
        Movie("Inception"),
        Movie("Spider-Man"),
        Movie("Jojo Rabbit")
    )

    val shows = listOf(
        Show("La casa de papel"),
        Show("Silicon Valley"),
        Show("Prison Break"),
    )

    @PostMapping("/movie")
    fun publishMovie() {
        moviePublisher.publishMovie(movies.random())
    }

    @PostMapping("/show")
    fun publishShow() {
        showPublisher.publishShow(shows.random())
    }
}