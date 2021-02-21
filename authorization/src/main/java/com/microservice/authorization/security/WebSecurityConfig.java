package com.microservice.authorization.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public WebSecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    @Bean("userDetailsService")
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    /*JDBC
    auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select username, password, enabled"
            + " from users where username=?")
        .authoritiesByUsernameQuery("select username, authority "
            + "from authorities where username=?")
        .passwordEncoder(new BCryptPasswordEncoder());
    */

    /*cache example
    * protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .jdbcAuthentication()
                // jdbc-user-service@dataSource
                .dataSource(this.dataSource)
                // jdbc-user-service@cache-ref
                .userCache(new CustomUserCache())
                // jdbc-user-service@users-byusername-query
                .usersByUsernameQuery("select principal,credentials,true from users where principal = ?")
                // jdbc-user-service@authorities-by-username-query
                .authoritiesByUsernameQuery("select principal,role from roles where principal = ?")
                // jdbc-user-service@group-authorities-by-username-query
                .groupAuthoritiesByUsername(JdbcUserDetailsManager.DEF_GROUP_AUTHORITIES_BY_USERNAME_QUERY)
                // jdbc-user-service@role-prefix
                .rolePrefix("ROLE_");

        }

        static class CustomUserCache implements UserCache {

            @Override
            public UserDetails getUserFromCache(String username) {
                return null;
            }

            @Override
            public void putUserInCache(UserDetails user) {
            }

            @Override
            public void removeUserFromCache(String username) {
            }
        }*/
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user1")
                    .password(encoder.encode("user1"))
                    .roles("USER")
                .and()
                .withUser("admin1")
                    .password(encoder.encode("admin1"))
                    .roles("USER", "ADMIN");
    }
}