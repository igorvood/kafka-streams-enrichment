package ru.vood.kafkastreamsenrichment.pipeline

import org.apache.kafka.streams.kstream.KStream
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkastreamsenrichment.dto.SomeDto

@Service
class SimpleStrPipe: IStreamPipe<String, String, String, String> {

    private val logger: Logger = LoggerFactory.getLogger(SimpleStrPipe::class.java)


    override fun apply(t: KStream<String, String>): KStream<String, String> {
        val groupBy = t
            .mapValues { v->
                logger.info("""message => $v""")
                v }

            return        groupBy

    }
}