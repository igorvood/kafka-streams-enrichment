package ru.vood.kafkastreamsenrichment.pipeline

import org.apache.kafka.streams.kstream.KStream
import ru.vood.kafkastreamsenrichment.dto.SomeDto

interface IStreamPipe<K1, V1, K2, V2>:  java.util.function.Function<KStream<K1, V1>, KStream<K2, V2>>