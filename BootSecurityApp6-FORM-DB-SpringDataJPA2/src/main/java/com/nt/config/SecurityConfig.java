//SecurityConfig.java
package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nt.service.IUserRegistrationService;

@Configuration
public class SecurityConfig {
	@Autowired
	 private IUserRegistrationService  userService;
	@Autowired
	 private  BCryptPasswordEncoder encoder;
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	     
	    authProvider.setUserDetailsService(userService);
	    authProvider.setPasswordEncoder(encoder);
	 
	    return authProvider;
	}
	
	    @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	     
		//autheticate and authorize urls
		http.authorizeRequests().antMatchers("/bank/").permitAll()
		                                                  .antMatchers("/user/register","/user/showLogin").permitAll()
		                                                 .antMatchers("/bank/offers").authenticated()
		                                                 .antMatchers("/bank/balance").hasAnyAuthority("MANAGER","CUSTOMER")
		                                                 .antMatchers("/bank/approveLoan").hasAuthority("MANAGER")
		                                                 .anyRequest().authenticated()
		                                                
		       // To enable BASIC Authentication (uses thr browser supplied dialog box)
		    // .and().httpBasic()
		           // To enable FORM based Authentication
		        .and().formLogin().defaultSuccessUrl("/bank/",true)
		        .loginPage("/user/showLogin")
		        .loginProcessingUrl("/login")
		        .failureUrl("/user/showLogin?error")
		        // Enables  remember ME option in Form Based Authentication
			       .and().rememberMe()
			       
			       // enable logout
			       //.and().logout()
			       //enable logout with custom url
			       .and().logout().logoutRequestMatcher(new  AntPathRequestMatcher("/bank/signout"))
			       .logoutSuccessUrl("/user/showLogin?logout")
			   
		       // cofigure custom error page for 403 error
		       .and().exceptionHandling().accessDeniedPage("/bank/denied")
		       // session max concurrency control
		       .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		
		       //specify AuthenticationProvider
		  http.authenticationProvider(authenticationProvider());
		return http.build();
	     
	}
	
	

}
