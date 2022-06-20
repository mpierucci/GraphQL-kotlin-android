package com.mpierucci.mockserver

import com.expediagroup.graphql.server.execution.GraphQLRequestParser
import com.expediagroup.graphql.server.types.GraphQLRequest
import com.expediagroup.graphql.server.types.GraphQLServerRequest
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.request.*
import java.io.IOException

/**
 * [GraphQLRequestParser] Interface is required to parse library-specific HTTP request
 * object into the common [GraphQLServerRequest] class
 *
 * This implementation is tailored for Ktor,
 */
class KtorGraphQLRequestParser(
    private val mapper: ObjectMapper
) : GraphQLRequestParser<ApplicationRequest> {
    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun parseRequest(request: ApplicationRequest): GraphQLServerRequest? = try {
        val rawRequest = request.call.receiveText()
        mapper.readValue(rawRequest, GraphQLRequest::class.java)
    } catch (ex: IOException) {
        throw IOException("Unable to parse GraphQL payload.")
    }
}
