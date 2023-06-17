package com.plantparadisemarket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	public SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception {
	http.authorizeHttpRequests( (auth)->
	auth.requestMatchers(HttpMethod.POST,"/ppm/registerCustomers").permitAll()
	.requestMatchers(HttpMethod.POST,"/aam/registerAdmin").permitAll()
	.requestMatchers(HttpMethod.POST,"/ppm/seeds","/ppm/plantSave","/ppm/planters").hasRole("ADMIN")
	.requestMatchers(HttpMethod.GET,"/ppm/**").hasAnyRole("ADMIN","USER")
	.requestMatchers(HttpMethod.GET,"/aam/**").hasRole("ADMIN")
	.requestMatchers("/deleteAdmin").hasRole("ADMIN")
	.requestMatchers(HttpMethod.PUT,"/ppm/**").hasRole("ADMIN")
	.requestMatchers(HttpMethod.DELETE,"/ppm/**").hasRole("ADMIN")
	.requestMatchers("/swagger-ui*/**","/v3/api-docs/**").permitAll()
	.anyRequest().authenticated()
	).csrf(csrf -> csrf.disable())
	.formLogin(Customizer.withDefaults())
	.httpBasic(Customizer.withDefaults());
	return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
}
