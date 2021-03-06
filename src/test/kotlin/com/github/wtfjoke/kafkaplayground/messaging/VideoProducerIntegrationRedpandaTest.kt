package com.github.wtfjoke.kafkaplayground.messaging

import com.github.wtfjoke.kafkaplayground.data.Movie
import com.github.wtfjoke.kafkaplayground.data.Show
import com.github.wtfjoke.kafkaplayground.messaging.config.TopicConfiguration
import com.github.wtfjoke.kafkaplayground.testcontainers.StartRedPandaBeforeAllExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.KafkaTemplate
import org.testcontainers.shaded.org.awaitility.Awaitility.await
import java.util.concurrent.TimeUnit


@ExtendWith(StartRedPandaBeforeAllExtension::class)
@SpringBootTest
class VideoProducerIntegrationRedpandaTest {

    @Autowired
    private lateinit var movieProducer: KafkaTemplate<String, Movie>

    @Autowired
    private lateinit var showProducer: KafkaTemplate<String, Show>

    @Autowired
    private lateinit var topics: TopicConfiguration

    @Test
    fun givenKafkaDockerContainer_whenSendingtoMovieProducer_thenMessageIsSent() {
        val send = movieProducer.send(topics.movie, Movie("hiho"))
        await().atMost(1, TimeUnit.MINUTES).until { send.isDone }

        val result = send.get()

        assertThat(result).isNotNull()
        assertThat(result.producerRecord.value()).isEqualTo(Movie("hiho"))
    }

    @Test
    fun givenKafkaDockerContainer_whenSendingtoShowProducer_thenMessageIsSent() {
        val send = showProducer.send(topics.show, Show("hiho"))
        await().atMost(1, TimeUnit.MINUTES).until { send.isDone }

        val result = send.get()

        assertThat(result).isNotNull()
        assertThat(result.producerRecord.value()).isEqualTo(Show("hiho"))
    }
}