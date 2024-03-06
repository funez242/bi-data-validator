package com.finvivir.process.bi.unit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * The class ProcessBiUnitApplication.
 */
@SpringBootApplication
@EnableAsync
@EnableFeignClients
@ComponentScan(basePackages = { "com.finvivir.process.bi.unit", "com.finvivir.process.bi.unit.provide" , "com.finvivir.process.bi.unit.crosscutting.configuration"})
public class BiDataValidatorApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(BiDataValidatorApplication.class, args);
	}

}
