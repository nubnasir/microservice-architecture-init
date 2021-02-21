package com.microservice.authorization.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/*-- Tables for OAuth token store

CREATE TABLE oauth_client_details (
client_id               VARCHAR(255) PRIMARY KEY,
resource_ids            VARCHAR(255),
client_secret           VARCHAR(255),
scope                   VARCHAR(255),
authorized_grant_types  VARCHAR(255),
web_server_redirect_uri VARCHAR(255),
authorities             VARCHAR(255),
access_token_validity   INTEGER,
refresh_token_validity  INTEGER,
additional_information  VARCHAR(4096),
autoapprove             TINYINT
);

CREATE TABLE oauth_client_token (
token_id          VARCHAR(255),
token             BLOB,
authentication_id VARCHAR(255),
user_name         VARCHAR(255),
client_id         VARCHAR(255)
);

CREATE TABLE oauth_access_token (
token_id          VARCHAR(255),
token             BLOB,
authentication_id VARCHAR(255),
user_name         VARCHAR(255),
client_id         VARCHAR(255),
authentication    BLOB,
refresh_token     VARCHAR(255)
);

CREATE TABLE oauth_refresh_token (
token_id       VARCHAR(255),
token          BLOB,
authentication BLOB
);

CREATE TABLE oauth_code (
code           VARCHAR(255),
authentication BLOB
);


Implementation
clients.jdbc(dataSource).withClient("clientapp")
           .authorizedGrantTypes("password", "refresh_token")
           .authorities("USER")
           .scopes("read", "write")
           .resourceIds(RESOURCE_ID)
           .secret("123456").and().build();
*/

@Configuration
public class OAuth2Config  extends AuthorizationServerConfigurerAdapter {

    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;

    @Autowired
    public OAuth2Config(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        clients.inMemory()
                .withClient("org_sys")
                .secret(encoder.encode("secret"))
                .authorizedGrantTypes(
                        "refresh_token",
                        "password",
                        "client_credentials"
                ).scopes("webclient", "mobileclient");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .pathMapping("/oauth/token", "/token");
    }

}
