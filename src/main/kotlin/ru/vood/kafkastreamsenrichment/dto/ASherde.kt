package ru.vood.kafkastreamsenrichment.dto

import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serde
import org.apache.kafka.common.serialization.Serializer

class ASherde<T>: Serde<T>{
    override fun serializer(): Serializer<T> {
        object : Serializer<T>{
            override fun serialize(topic: String?, data: T): ByteArray {
                TODO("Not yet implemented")
            }
        }

        TODO("Not yet implemented")
    }

    override fun deserializer(): Deserializer<T> {
        TODO("Not yet implemented")
    }
}
