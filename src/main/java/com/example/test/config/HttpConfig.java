package com.example.test.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class HttpConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(crs -> crs.disable()).authorizeHttpRequests(
                req -> req.requestMatchers("/newuser").permitAll().requestMatchers("/asset/*").permitAll()
                        .requestMatchers("/test").authenticated().requestMatchers("/login").permitAll()
                        .requestMatchers("/updateForm").authenticated().requestMatchers("/").authenticated()
                        .requestMatchers("/updateUser").authenticated())
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/test").failureUrl("/login?error=true")
                .and().httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
