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
	
	
	@Override
	public  void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.ldapAuthentication().contextSource().url("ldap://localhost:10389/o=nit")
		  .managerDn("uid=admin,ou=system").managerPassword("secret")  // This is to connect to ldap server
		  .and().userSearchBase("ou=users").userSearchFilter("(cn={0})")   //For Auhentication
		  .groupSearchBase("ou=roles").groupSearchFilter("(uniqueMember={0})")
		  .groupRoleAttribute("cn").rolePrefix("ROLE_");   // for  Autthorization
		
				
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
		
	     
	}//method
	
	

}//class
