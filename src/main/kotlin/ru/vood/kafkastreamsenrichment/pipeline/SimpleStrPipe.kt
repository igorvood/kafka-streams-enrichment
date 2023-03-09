package ru.vood.kafkastreamsenrichment.pipeline

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement
import org.apache.kafka.streams.kstream.KStream
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkastreamsenrichment.dto.JsError
import ru.vood.kafkastreamsenrichment.dto.JsSuccess
import ru.vood.kafkastreamsenrichment.dto.SomeDto

@Service
class SimpleStrPipe: IStreamPipe<String, String, String, SomeDto> {

    private val logger: Logger = LoggerFactory.getLogger(SimpleStrPipe::class.java)


    override fun apply(t: KStream<String, String>): KStream<String, SomeDto> {
        val groupBy = t
            .mapValues { v ->
                kotlin.runCatching { JsSuccess(Json.parseToJsonElement(v)) }
                    .getOrElse { JsError(it.message) }
            }
            .filter { key, value ->  value is JsSuccess }
            .mapValues { value ->  value as JsSuccess }
            .mapValues { v->
                logger.info("""messageeeee => $v""")
                kotlin.runCatching { JsSuccess(Json.decodeFromJsonElement<SomeDto>(v.data)) }
                    .getOrElse { JsError(it.message) }
            }
            .filter { key, value ->  value is JsSuccess }
            .mapValues { value ->  value as JsSuccess }
            .mapValues { v->v.data }


            return        groupBy

    }
}