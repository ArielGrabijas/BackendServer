package com.github.arielgrabijas.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/verification/**", "/api/signup/**", "/signup/**", "/registerClient/**").permitAll() // Everything under /signup/** will
                                                                                                                   // be available for any kind of
                                                                                                                   // request. Even unauthorized one.
                .antMatchers("/api/premium/**").hasRole("PREMIUM")
                // .antMatchers("/api/user/**").hasAnyRole("PREMIUM","FREE")
                .anyRequest().authenticated();

    }
}
