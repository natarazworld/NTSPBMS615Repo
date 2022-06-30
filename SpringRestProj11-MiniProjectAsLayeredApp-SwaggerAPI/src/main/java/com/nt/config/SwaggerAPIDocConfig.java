// SwaggerAPIDocConfig.java
package com.nt.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerAPIDocConfig {
	
	
	@Bean
	public Docket  createDocket() {
		return  new Docket(DocumentationType.SWAGGER_2)  // Swagger UI type
				                    .select() 
				                    .apis(RequestHandlerSelectors.basePackage("com.nt.rest"))  // to specify base pkg of @RestController clases
				                    .paths(PathSelectors.regex("/actor.*"))  // global path
				                    .build() //Buids Docket obj
				                    .useDefaultResponseMessages(true)
				                    .apiInfo(createAPIInfo());
	}
	
	
	//helper method
	private   ApiInfo createAPIInfo() {
		Contact contact=new Contact("raja","https://www.nareshit.com/SPRest","natarazjavaarena@gmail.com");
		
		 return new ApiInfo("Actor-API Doc1",
				                              "API Info Actor API",
				                              "5.7.RELEASE",
				                              "http://www.nareshit.com/license",
				                              contact,
				                              "GNU Public",
				                              "http://www.gnu.license.com",
				                              Collections.emptyList());
	}

}
