package com.br.fabiobrasileiro.gestao_vagas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
          auth
              // Libera apenas POST em rotas específicas (resto fica bloqueado)
              .requestMatchers(HttpMethod.POST, "/candidate/**").permitAll()
              .requestMatchers(HttpMethod.POST, "/company/**").permitAll()

              // Todas as outras rotas precisam autenticação
              .anyRequest().authenticated();
        });
    return http.build();
  }

  @Bean
  PasswordEncoder passwordEnconder() {
    return new BCryptPasswordEncoder();
  }
}
