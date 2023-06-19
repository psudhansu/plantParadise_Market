package com.plantparadisemarket;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import jakarta.servlet.http.HttpServletRequest;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	public SecurityFilterChain masaiSecurityConfig(HttpSecurity http) throws Exception {
	
		http.cors(co -> {

			co.configurationSource(new CorsConfigurationSource() {

				@Override
				public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
					CorsConfiguration cfg = new CorsConfiguration();

					cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
					cfg.setAllowedMethods(Collections.singletonList("*"));
					cfg.setAllowCredentials(true);
					cfg.setAllowedHeaders(Collections.singletonList("*"));
					cfg.setExposedHeaders(Arrays.asList("Authorization"));
					return cfg;
				}
			});
		
		}).authorizeHttpRequests( (auth)->
	auth.requestMatchers(HttpMethod.POST,"/ppm/registerCustomers").permitAll()
	.requestMatchers(HttpMethod.POST,"/aam/registerAdmin","/ppm/logout").permitAll()
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
	.httpBasic(Customizer.withDefaults())
	 .logout()
     .logoutUrl("/logout") // Specify the logout URL
     .logoutSuccessUrl("/login") // Redirect to the login page after successful logout
     .invalidateHttpSession(true)
     .deleteCookies("JSESSIONID");
	return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
}
