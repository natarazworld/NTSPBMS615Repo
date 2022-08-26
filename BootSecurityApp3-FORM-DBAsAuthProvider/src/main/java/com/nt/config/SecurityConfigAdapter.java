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

@Configuration
@EnableWebSecurity
public class SecurityConfigAdapter extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource ds;
	
	@Override
	public  void configure(AuthenticationManagerBuilder auth) throws Exception {
		//InMemory DB

		/*  auth.inMemoryAuthentication().withUser("raja").password("{noop}rani").roles("CUSTOMER");
		  auth.inMemoryAuthentication().withUser("rajesh").password("{noop}hyd").roles("MANAGER");
		  auth.inMemoryAuthentication().withUser("jani").password("{noop}begum").roles("MANAGER","CLERK");
		  auth.inMemoryAuthentication().withUser("suresh").password("{noop}delhi").roles("VISITOR");*/
	    
		/*//InMemory DB with Encoded Passwords
		 auth.inMemoryAuthentication().passwordEncoder( new BCryptPasswordEncoder()).withUser("raja").password("$2a$10$Sws4eLbLoDoUZjC26QAa8ujWzquLfknQwZDkAtXI8f84gYhwe0ZvS").roles("CUSTOMER");
		 auth.inMemoryAuthentication().withUser("rajesh").password("$2a$10$VG.cYdU3TK47RXraenU6POAjlPyt7iJoZ0KiDz1vUCNZYWgIUhiyi").roles("MANAGER");
		  auth.inMemoryAuthentication().withUser("jani").password("$2a$10$X3Pay9m0duag8wXCqn.4FO8xGz8Kbktbkj0wWBnnPUp7Gd.Rn635.").roles("MANAGER","CLERK");
		  auth.inMemoryAuthentication().withUser("suresh").password("$2a$10$uHrUdPt6kGK.c2vuYXlOYO2r8Syh2SjhpDhKSKVfpPHrU97fcMe/2").roles("VISITOR");*/
	
		  //using Db s/w as Authentication Info provider thorugh spring jdbc
				auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
				.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")
				.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM USERS_ROLES WHERE UNAME=?");

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
		    // .and().httpBasic()
		           // To enable FORM based Authentication
		        .and().formLogin()
		        // Enables  remember ME option in Form Based Authentication
			       .and().rememberMe()
			       
			       // enable logout
			       //.and().logout()
			       //enable logout with custom url
			       .and().logout().logoutRequestMatcher(new  AntPathRequestMatcher("/signout"))
			   
		       // cofigure custom error page for 403 error
		       .and().exceptionHandling().accessDeniedPage("/denied")
		       // session max concurrency control
		       .and().sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true);
		
	     
	}
	
	

}
