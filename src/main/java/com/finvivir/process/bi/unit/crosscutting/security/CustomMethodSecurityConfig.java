package com.finvivir.process.bi.unit.crosscutting.security;


import com.finvivir.api.auth.CustomMethodSecurityExpressionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

/**
 * The class Custom method security config.
 */
@Configuration
@EnableMethodSecurity
public class CustomMethodSecurityConfig {

    /**
     * Method security expression handler method security expression handler.
     *
     * @return the method security expression handler
     */
    @Bean
    static MethodSecurityExpressionHandler
    methodSecurityExpressionHandler() {
       return new CustomMethodSecurityExpressionHandler();
    }

}