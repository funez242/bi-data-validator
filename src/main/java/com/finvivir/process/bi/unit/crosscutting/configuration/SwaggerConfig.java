package com.finvivir.process.bi.unit.crosscutting.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

/**
 * The class Swagger config.
 */
@Configuration
public class SwaggerConfig {
	
	private static final String CURRENT_VERSION = "1.6.4";

    /**
     * Spring shop open api open api.
     *
     * @return the open api
     */
    @Bean
	public OpenAPI springShopOpenAPI() { // for general information in OpenAPI documentation
		final String securitySchemeName = "bearerAuth";
		return new OpenAPI()
	    	.addServersItem(new Server().url("/"))
	    	.components(new Components().addSecuritySchemes(securitySchemeName,
                    new SecurityScheme().type(SecurityScheme.Type.HTTP)
                    .scheme("bearer").name(securitySchemeName)))
	    	.info(new Info().title("bi-data-validator-API")
	        .description("API to support the business validation data.")
	        .version(CURRENT_VERSION))
	        .externalDocs(new ExternalDocumentation()
	        .description("springdoc-openapi")
	        .url("http://springdoc.org"))
	        .addSecurityItem(new SecurityRequirement().addList(securitySchemeName));
	}
}
