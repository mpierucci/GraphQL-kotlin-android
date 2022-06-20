package com.mpierucci.mockserver

import com.expediagroup.graphql.generator.execution.GraphQLContext
import com.expediagroup.graphql.server.execution.GraphQLContextFactory
import io.ktor.request.*

/**
 *
 */
class KtorGraphQLContextFactory : GraphQLContextFactory<GraphQLContext, ApplicationRequest> {

    override suspend fun generateContextMap(request: ApplicationRequest): Map<Any, Any> {
        return emptyMap()
    }

    override suspend fun generateContext(request: ApplicationRequest): GraphQLContext? = null
}
