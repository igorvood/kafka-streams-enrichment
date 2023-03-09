package ru.vood.kafkastreamsenrichment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KafkaStreamsEnrichmentApplication

fun main(args: Array<String>) {
    runApplication<KafkaStreamsEnrichmentApplication>(*args)
}
