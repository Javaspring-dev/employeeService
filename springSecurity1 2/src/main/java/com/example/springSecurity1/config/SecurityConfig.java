package com.example.springSecurity1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
        UserDetails admin= User.withUsername("pugal")
                .password(passwordEncoder().encode("1234"))
                .roles("ADMIN")
                .build();

        UserDetails user= User.withUsername("gokul")
                .password(passwordEncoder().encode("1234"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf-> csrf.disable()) // Consider re-enabling CSRF in production
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/products/welcome").permitAll()
                        .requestMatchers("/products/**").authenticated()
                )
                .formLogin(login-> login.loginPage("/signin"));
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
