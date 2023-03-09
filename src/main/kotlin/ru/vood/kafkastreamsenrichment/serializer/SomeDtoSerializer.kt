package ru.vood.kafkastreamsenrichment.serializer

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.internal.readJson
import org.apache.kafka.common.serialization.Deserializer
import org.apache.kafka.common.serialization.Serializer
import ru.vood.kafkastreamsenrichment.dto.SomeDto

class SomeDtoSerializer: Deserializer<SomeDto> {
    override fun deserialize(topic: String?, data: ByteArray?): SomeDto {
        val let = data
            ?.let { String(it) }
            ?.let { Json.parseToJsonElement(it) }
            ?.let { Json.decodeFromJsonElement<SomeDto>(it) }!!

        return let
    }
}