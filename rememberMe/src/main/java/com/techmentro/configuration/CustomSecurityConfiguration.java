package com.techmentro.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.techmentro.daos.MyUserDetailsService;

@EnableWebSecurity
public class CustomSecurityConfiguration extends
			WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired 
	MyUserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(
			AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder=passwordEncoder();
		auth
			.inMemoryAuthentication()
			.passwordEncoder(encoder)
			.withUser("neeraj@gmail.com")
			.password(encoder.encode("1234"))
			.roles("ADMIN");
		
		
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			
		     .authorizeRequests()
		     		.antMatchers("/webjars/**")
		     				.permitAll()
		     		.anyRequest()
		     			.authenticated()
		     				.and()
		     .formLogin()
		     		.loginPage("/login")
		     		.permitAll()
		     		.and()
		      .logout()
		      		.permitAll()
		      		.and()
		      .rememberMe()
		       	.rememberMeParameter("remember-me")
		      	.tokenRepository(persistentTokenRepository());		
		     		
	}
	
	@Bean
	public PersistentTokenRepository 
	persistentTokenRepository() {
		JdbcTokenRepositoryImpl db = 
				new JdbcTokenRepositoryImpl();
		db.setDataSource(dataSource);
		return db;
	}
	
	

}
