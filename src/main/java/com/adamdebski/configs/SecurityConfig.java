package com.adamdebski.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password")).roles("USER")
		.and().withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
	 http
         .authorizeRequests()
         .antMatchers("/css/**").permitAll()
         .antMatchers("/js/**").permitAll()
         .antMatchers("/").anonymous()
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/")
         .defaultSuccessUrl("/")
         .failureUrl("/?error=true")
         .and()
         .logout().logoutSuccessUrl("/");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

}