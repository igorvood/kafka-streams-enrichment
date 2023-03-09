package ru.vood.kafkastreamsenrichment.pipeline

import kotlinx.serialization.json.Json
import org.apache.kafka.streams.kstream.KStream
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkastreamsenrichment.dto.SomeDto

@Service
class SimpleStrPipe: IStreamPipe<String, String, String, SomeDto> {

    private val logger: Logger = LoggerFactory.getLogger(SimpleStrPipe::class.java)


    override fun apply(t: KStream<String, String>): KStream<String, SomeDto> {
        val groupBy = t
            .mapValues { v->
                logger.info("""message => $v""")
                val decodeFromString = Json.decodeFromString(SomeDto.serializer(), v)
                decodeFromString }

            return        groupBy

    }
}