package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;
import org.springframework.web.servlet.view.XmlViewResolver;

@SpringBootApplication
public class BootMvcProj02WishMessageAppApplication {
	
	/*@Bean
	public   ViewResolver  createUBVResolver() {
		System.out.println("BootMvcProj02WishMessageAppApplication.createUBVResolver()");
		 UrlBasedViewResolver resolver=new UrlBasedViewResolver();
		 resolver.setPrefix("/WEB-INF/pages/");
		 resolver.setSuffix(".jsp");
		 //resolver.setViewClass(InternalResourceView.class);
		 resolver.setViewClass(JstlView.class);
		 return resolver;
	}*/
	

	/*@Bean
	public   ViewResolver  createIRVResolver() {
		System.out.println("BootMvcProj02WishMessageAppApplication.createUBVResolver()");
	     InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		 resolver.setPrefix("/WEB-INF/pages/");
		 resolver.setSuffix(".jsp");
		 return resolver;
	}*/
	
		@Bean
		public   ViewResolver  createRBVResolver() {
	  System.out.println("BootMvcProj02WishMessageAppApplication.createRBVResolver()");
		     ResourceBundleViewResolver resolver=new ResourceBundleViewResolver();
			 resolver.setBasename("com/nt/commons/views");
			 return resolver;
		}
	
	@Bean
	public   ViewResolver  createXVResolver() {
  System.out.println("BootMvcProj02WishMessageAppApplication.createXVResolver()");
	    XmlViewResolver resolver=new XmlViewResolver();
		 resolver.setLocation(new ClassPathResource("com/nt/cfgs/views.xml"));
		 return resolver;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj02WishMessageAppApplication.class, args);
	}

}
