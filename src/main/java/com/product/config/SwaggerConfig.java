package com.product.config;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
				
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ApiInfo apiInfo() {
		
		ArrayList<VendorExtension> list= new ArrayList();
		return new ApiInfo("Product API Documentation", 
				"List of all API related to product", 
				"v1", 
				"", 
				new Contact("APi-Product", "", "product@product.com"), 
				"", 
				"",list);
	}
}