package ru.vood.kafkastreamsenrichment.dlq

import org.apache.kafka.streams.errors.StreamsUncaughtExceptionHandler

class SStreamsUncaughtExceptionHandler: StreamsUncaughtExceptionHandler {

    override fun handle(exception: Throwable?): StreamsUncaughtExceptionHandler.StreamThreadExceptionResponse {
        StreamsUncaughtExceptionHandler.StreamThreadExceptionResponse.REPLACE_THREAD
        TODO("Not yet implemented")
    }
}