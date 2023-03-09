package ru.vood.kafkastreamsenrichment.dto

sealed interface JsResult<T>

data class JsError(val error: String?):  JsResult<Nothing>

data class JsSuccess<T>(val data: T):  JsResult<T>