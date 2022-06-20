package energy.octopus.fieldservices.server.mock.schema.queries

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.server.operations.Query
import com.mpierucci.mockserver.schema.models.UserConfiguration

class ConfigurationQuery : Query {
    @GraphQLDescription("Return user configuration")
    fun configuration() = UserConfiguration()
}
