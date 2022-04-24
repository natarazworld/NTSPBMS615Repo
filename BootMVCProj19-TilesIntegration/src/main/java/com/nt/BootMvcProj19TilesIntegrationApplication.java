package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@SpringBootApplication
public class BootMvcProj19TilesIntegrationApplication {
	
	
	@Bean
	public  TilesConfigurer  createTilesConfigurer() {
		System.out.println("BootMvcProj19TilesIntegrationApplication.createTilesConfigurer()");
		TilesConfigurer  configurer=new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles.xml");
		return configurer;
	}
	
	@Bean
	public  TilesViewResolver  createTVResolver() {
		System.out.println("BootMvcProj19TilesIntegrationApplication.createTilesConfigurer()");
		   TilesViewResolver resolver=new TilesViewResolver();
		   return resolver;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj19TilesIntegrationApplication.class, args);
	}

}
