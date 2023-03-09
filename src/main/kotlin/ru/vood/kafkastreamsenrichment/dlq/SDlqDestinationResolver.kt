package ru.vood.kafkastreamsenrichment.dlq

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.cloud.stream.binder.kafka.utils.DlqDestinationResolver
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class SDlqDestinationResolver: DlqDestinationResolver {

    override fun apply(t: ConsumerRecord<*, *>?, u: Exception?): String {
        return "dev__bevents__realtime__aggregate_first_salary__dlq"
    }
}