package com.uniguard.core.config

import io.r2dbc.spi.Connection
import io.r2dbc.spi.ConnectionFactory
import io.r2dbc.spi.ConnectionFactoryMetadata
import org.reactivestreams.Publisher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Mono

@Configuration
class R2dbcTenantContextConfig {

    @Bean
    fun tenantConnectionFactory(connectionFactory: ConnectionFactory): ConnectionFactory {
        return TenantAwareConnectionFactory(connectionFactory)
    }

    class TenantAwareConnectionFactory(private val target: ConnectionFactory) : ConnectionFactory {
        override fun create(): Publisher<out Connection> {
            return Mono.from(target.create()).flatMap { connection ->
                Mono.deferContextual { ctx ->
                    val tenantId = ctx.getOrDefault("tenantId", "system").toString()
                    require(tenantId.matches(Regex("^[a-zA-Z0-9_-]+$"))) { "Invalid tenant ID format" }
                    Mono.from(connection.createStatement("SET LOCAL app.current_tenant_id = '$tenantId'").execute())
                        .thenReturn(connection)
                }
            }
        }

        override fun getMetadata(): ConnectionFactoryMetadata = target.metadata
    }
}
