package com.assessment.shoppe.config;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class ShoppeConfig {
	
	@Bean
	public TimedAspect timedAspect(MeterRegistry registry) { //This config enables Micrometer to add a timer to custom methods
	    return new TimedAspect(registry);
	}
}
