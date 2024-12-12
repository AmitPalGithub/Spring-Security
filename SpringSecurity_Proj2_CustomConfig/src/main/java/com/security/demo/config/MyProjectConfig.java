package com.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MyProjectConfig {
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.httpBasic(Customizer.withDefaults())
		.authorizeHttpRequests(c->c.anyRequest().permitAll());
		
		return httpSecurity.build();
	}
	
	

	@Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails userDetails = User.withUsername("amitpal")
									.password("123amit")
									.authorities("read")
									.build();
		
		UserDetailsService userDetailsService = new InMemoryUserDetailsManager(userDetails);
		return userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
