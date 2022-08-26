package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nt.service.IUserRegistrationService;

@Configuration
@EnableWebSecurity
public class SecurityConfigAdapter extends WebSecurityConfigurerAdapter {
	@Autowired
	 private IUserRegistrationService  userSerivce;
	@Autowired
	 private  BCryptPasswordEncoder enconder;
	
	@Override
	public  void configure(AuthenticationManagerBuilder auth) throws Exception {
		//specifying the spring data jpa related  service class as the authentication info provider
		auth.userDetailsService(userSerivce).passwordEncoder(enconder);

	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
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
		       
		
	     
	}
	
	

}
