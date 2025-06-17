package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	//DI
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(authz -> authz
			  //認可の設定
			  .requestMatchers("/board/create_thread","/admin/**").hasAuthority("ADMIN")
			  .requestMatchers("/login","/style.css","/board/**","/thread/**","/board/create_user").permitAll()
			  .anyRequest().authenticated())
			  //ログインの設定
			  .formLogin(form ->form.loginPage("/login") 
			  .loginProcessingUrl("/authentication")
			  .usernameParameter("usernameInput")
			  .passwordParameter("passwordInput")
			  .defaultSuccessUrl("/board/0",true)
			  .failureUrl("/login?error"))
			  //ログアウトの設定
			  .logout(logout -> logout
			  .logoutUrl("/logout")
			  //ログアウト後のURL
			  .logoutSuccessUrl("/login?logout")
			  .invalidateHttpSession(true)
			  .deleteCookies("JSESSIONID")
			  );
		
		return http.build();
	}
}
