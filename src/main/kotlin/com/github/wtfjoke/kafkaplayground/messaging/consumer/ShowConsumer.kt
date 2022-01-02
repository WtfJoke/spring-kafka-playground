package com.github.wtfjoke.kafkaplayground.messaging.consumer

import com.github.wtfjoke.kafkaplayground.data.Show
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class ShowConsumer {

    @KafkaListener(topics = ["\${topics.show}"], containerFactory = "showPublishedKafkaListenerContainerFactory")
    fun listenToShowUpdates(show: Show) {
        println("I watched show: $show")
    }
}