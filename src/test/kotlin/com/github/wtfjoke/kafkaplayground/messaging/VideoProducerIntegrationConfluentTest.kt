package com.github.wtfjoke.kafkaplayground.messaging

import com.github.wtfjoke.kafkaplayground.data.Movie
import com.github.wtfjoke.kafkaplayground.data.Show
import com.github.wtfjoke.kafkaplayground.testcontainers.StartKafkaContainerBeforeAllExtension
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.kafka.core.KafkaTemplate
import org.testcontainers.shaded.org.awaitility.Awaitility.await
import java.util.concurrent.TimeUnit


@ExtendWith(StartKafkaContainerBeforeAllExtension::class)
@SpringBootTest
class VideoProducerIntegrationConfluentTest {

    @Autowired
    private lateinit var movieProducer: KafkaTemplate<String, Movie>

    @Autowired
    private lateinit var showProducer: KafkaTemplate<String, Show>

    @Value("\${topics.movie}")
    private lateinit var movieTopic: String

    @Value("\${topics.show}")
    private lateinit var showTopic: String

    @Test
    fun givenKafkaDockerContainer_whenSendingtoMovieProducer_thenMessageIsSent() {
        val send = movieProducer.send(movieTopic, Movie("hiho"))
        await().atMost(5, TimeUnit.SECONDS).until { send.isDone }

        val result = send.get()

        assertThat(result).isNotNull()
        assertThat(result.producerRecord.value()).isEqualTo(Movie("hiho"))
    }

    @Test
    fun givenKafkaDockerContainer_whenSendingtoShowProducer_thenMessageIsSent() {
        val send = showProducer.send(showTopic, Show("hiho"))
        await().atMost(5, TimeUnit.SECONDS).until { send.isDone }

        val result = send.get()

        assertThat(result).isNotNull()
        assertThat(result.producerRecord.value()).isEqualTo(Show("hiho"))
    }
}