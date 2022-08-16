package com.nt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfigAdapter extends WebSecurityConfigurerAdapter {
	
	@Override
	public  void configure(AuthenticationManagerBuilder auth) throws Exception {
		//InMemory DB
	   auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
	   auth.inMemoryAuthentication().withUser("rajesh").password("{noop}hyd").roles("MANAGER");
	   auth.inMemoryAuthentication().withUser("jani").password("{noop}begum").roles("MANAGER","CLERK");
	   auth.inMemoryAuthentication().withUser("suresh").password("{noop}delhi").roles("VISITOR");
	    
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		//autheticate and authorize urls
		http.authorizeRequests().antMatchers("/").permitAll()
		                                                 .antMatchers("/offers").authenticated()
		                                                 .antMatchers("/balance").hasAnyRole("MANAGER","CUSTOMER")
		                                                 .antMatchers("/approveLoan").hasRole("MANAGER")
		                                                 .anyRequest().authenticated()
		       // To enable BASIC Authentication (uses thr browser supplied dialog box)
		     .and().httpBasic()
		     
		// cofigure custom error page for 403 error
		 .and().exceptionHandling().accessDeniedPage("/denied");
	}
	
	

}
