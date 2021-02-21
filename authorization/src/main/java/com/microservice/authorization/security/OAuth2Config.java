package com.microservice.authorization.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

import javax.sql.DataSource;

@Configuration
public class OAuth2Config  extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private DataSource dataSource;

    public OAuth2Config(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, DataSource dataSource) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.dataSource = dataSource;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        clients.jdbc(dataSource)
                .passwordEncoder(encoder)
                .build();
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .pathMapping("/oauth/token", "/token");
    }

}
