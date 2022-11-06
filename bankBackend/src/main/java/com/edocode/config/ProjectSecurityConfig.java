package com.edocode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests()
			.antMatchers("/myAccount", "/myBalance", "/myLoans", "/myCards").authenticated()
			.antMatchers("/notices", "/contact", "/register").permitAll()
		.and().formLogin()
		.and().httpBasic();
		return http.build();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource) {
//		 return new JdbcUserDetailsManager(dataSource);
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}