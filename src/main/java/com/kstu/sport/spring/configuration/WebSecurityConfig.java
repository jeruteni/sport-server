package com.kstu.sport.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CorsFilter corsFilter;

    public WebSecurityConfig(
            CorsFilter corsFilter
    ) {
        this.corsFilter = corsFilter;
    }

    // Configure BCrypt password encoder =====================================================================

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(11);
    }

    // Configure paths and requests that should be ignored by Spring Security ================================

//    @Override
//    public void configure(WebSecurity web) {
//        web.ignoring()
//                .antMatchers(HttpMethod.OPTIONS, "/**")
//
//                // allow anonymous resource requests
//                .antMatchers(
//                        "/",
//                        "/*.html",
//                        "/favicon.ico",
//                        "/**/*.html",
//                        "/**/*.css",
//                        "/**/*.js",
//                        "/h2-console/**"
//                );
//    }

    // Configure security settings

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // Пока разрешим всем запросы кидать на контроллеры
        httpSecurity
                .cors().and().csrf().disable()
                .authorizeRequests().anyRequest().permitAll();

    }

}
