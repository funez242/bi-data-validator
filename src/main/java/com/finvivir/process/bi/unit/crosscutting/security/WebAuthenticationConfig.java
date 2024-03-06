package com.finvivir.process.bi.unit.crosscutting.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 * Esta clase habilita la validación de tokens
 * Description: Spring Security 6 Authentication configuration
 *
 * @author humbertocervantes
 *
 */
@Configuration
@EnableWebSecurity
public class WebAuthenticationConfig {

    /**
     * Filter chain security filter chain.
     *
     * @param http the http
     * @return the security filter chain
     * @throws Exception the exception
     */
    @Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(expressionInterceptUrlRegistry ->
		expressionInterceptUrlRegistry.requestMatchers("/swagger-ui**","/api-docs/**", "/swagger-resources/**",
				"/actuator**", "/actuator/**", "/swagger-resources/**", "/h2-console/**").permitAll().anyRequest().authenticated())
			.oauth2ResourceServer(oauth2 -> oauth2
			.jwt(Customizer.withDefaults())
			);
		return http.getOrBuild();
	}

    /**
     * Web security customizer web security customizer.
     *
     * @return the web security customizer
     */
    @Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs.yaml",
				"/actuator**", "/h2-console/**", "/v3/api-docs/", "/v1/paymentsCollection/cancell/**","/error");
	}

}
