package com.customers.config

import com.atlassian.oai.validator.OpenApiInteractionValidator
import com.atlassian.oai.validator.springmvc.OpenApiValidationFilter
import com.atlassian.oai.validator.springmvc.OpenApiValidationInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.servlet.Filter


@Configuration
open class ValidationConfig : WebMvcConfigurer {
    var validationInterceptor: OpenApiValidationInterceptor =
        OpenApiValidationInterceptor(OpenApiInteractionValidator.createFor("/api/customer.yaml").build());

    @Bean
    open fun validationFilter(): Filter? {
        return OpenApiValidationFilter(
            true,
            true)
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(validationInterceptor)
    }
}