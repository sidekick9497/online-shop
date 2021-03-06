package com.cognizant.apigateway;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource);

	}

	// secure the application : define the accessibility rule

	@Override

	protected void configure(HttpSecurity http) throws Exception {

		http
			.cors() // auto configures application to use CrossOrigins
		.and()
			.csrf().disable() // form security will not conflict
			.authorizeRequests()
				//.antMatchers("/user-service/signup").permitAll()
				.antMatchers("/user-service/login").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
				
				// add other antmatcher of plumbing MS
				
		.and()
				.httpBasic();

	}
	
	
	
}
