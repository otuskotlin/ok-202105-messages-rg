package com.support.configuration

import com.support.service.SupportService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class SpringConfiguration {
    @Bean
    open fun supportService():SupportService{
        return SupportService()
    }

}