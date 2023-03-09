package ru.vood.kafkastreamsenrichment.pipeline

import org.apache.kafka.streams.kstream.KStream
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.vood.kafkastreamsenrichment.dto.SomeDto

@Service
class SimplePipe: IStreamPipe<String, SomeDto, String, SomeDto> {

    private val logger: Logger = LoggerFactory.getLogger(SimplePipe::class.java)


    override fun apply(t: KStream<String, SomeDto>): KStream<String, SomeDto> {
        val groupBy = t
            .mapValues { v->
                logger.info("""message => $t""")
                v.copy(dataString = v.dataString.plus("q" to "w")) }

            return        groupBy

    }
}