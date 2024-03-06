package com.finvivir.process.bi.unit.crosscutting.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement.BadFormatException;
import com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement.ExternalServerErrorException;
import com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement.ObjectNotFoundException;
import com.finvivir.process.bi.unit.crosscutting.configuration.errormanagement.ResourceAlreadyExistsException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;
import feign.okhttp.OkHttpClient;

/**
 * The class Feign configuration.
 * Description: Feign Client´s config.
 */
@Configuration
public class FeignConfiguration {
    /**
     * Client ok http client.
     *
     * @return the ok http client
     */
    @Bean
	public OkHttpClient client() {
		return new OkHttpClient();
	}

    /**
     * Error decoder my error decoder.
     *
     * @return MyErrorDecoder
     */
    @Bean
	public MyErrorDecoder errorDecoder() {
		return new MyErrorDecoder();
	}

    /**
     * The class My error decoder.
     */
    public class MyErrorDecoder implements ErrorDecoder {

		private final ErrorDecoder defaultErrorDecoder = new Default();
		private static final String MAPKEY = "message";
		@Override
		public Exception decode(String methodKey, Response response) {

			try (InputStream bodyIs = response.body().asInputStream()) {
				ObjectMapper mapper = new ObjectMapper();
				@SuppressWarnings("unchecked")
				Map<String, Object> map = mapper.readValue(bodyIs, Map.class);
				if (map.containsKey(MAPKEY)) {
					switch (response.status()) {
					case 400:
						return new BadFormatException(map.get(MAPKEY).toString());
					case 404:
						return new ObjectNotFoundException(map.get(MAPKEY).toString());
					case 409:
						return new ResourceAlreadyExistsException(map.get(MAPKEY).toString());
					default:
						return new ExternalServerErrorException(map.get(MAPKEY).toString());

					}
				}
			} catch (IOException e) {
				return new Exception(e.getMessage());
			}

			return defaultErrorDecoder.decode(methodKey, response);
		}

	}

}