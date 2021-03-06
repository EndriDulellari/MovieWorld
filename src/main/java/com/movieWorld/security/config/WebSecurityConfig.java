package com.movieWorld.security.config;

import com.movieWorld.security.authentication.UserService;
import com.movieWorld.security.oauth.CustomOAuth2UserService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService service;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private CustomOAuth2UserService oAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/oauth2/**").permitAll()
                //This makes company as an endpoint that can be accessed only if you are authenticated
                .antMatchers("/company/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .usernameParameter("email")
                .permitAll()
                .defaultSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint().userService(oAuth2UserService)
                .and()
                .and()
                .logout().permitAll()
                .and()
                .rememberMe()
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(service);
        return provider;
    }

}
