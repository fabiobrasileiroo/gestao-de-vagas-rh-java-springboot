package com.br.fabiobrasileiro.gestao_vagas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  @Autowired
  private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .exceptionHandling(ex -> ex
            .authenticationEntryPoint(customAuthenticationEntryPoint))
        .authorizeHttpRequests(auth -> {
          auth.requestMatchers("/candidate/**").permitAll()
              .requestMatchers("/company/**").permitAll();
          auth.anyRequest().authenticated();
        });
    return http.build();
  }
}
