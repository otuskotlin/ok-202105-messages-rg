package com.messages.configuration

import org.keycloak.adapters.KeycloakConfigResolver
import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.session.SessionRegistryImpl
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy


@EnableWebSecurity
open class GlobalSecurityConfiguration : KeycloakWebSecurityConfigurerAdapter() {
    @Bean
    override fun sessionAuthenticationStrategy(): SessionAuthenticationStrategy {
        return RegisterSessionAuthenticationStrategy(SessionRegistryImpl())
    }

    @Bean
    open fun keycloakConfigResolver(): KeycloakConfigResolver {
        return KeycloakSpringBootConfigResolver()
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        val keycloakAuthenticationProvider = keycloakAuthenticationProvider()
        auth.authenticationProvider(keycloakAuthenticationProvider)
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        super.configure(http)
        http
            .authorizeRequests()
            .anyRequest()
            .authenticated()
    }
}