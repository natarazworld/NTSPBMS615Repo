//IUserRegistrationService.java
package com.nt.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nt.model.UserDetails;

public interface IUserRegistrationService extends  UserDetailsService{
   public  String registerUser(UserDetails details);
}
