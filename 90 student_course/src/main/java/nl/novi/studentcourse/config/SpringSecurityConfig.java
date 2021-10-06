package nl.novi.studentcourse.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public CustomUserDetailsService customUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Secure the endpoints with HTTP Basic authentication
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
            //HTTP Basic authentication
            .httpBasic()
                .and()
            .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/courses/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/students/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("USER") // per user authorization in UserService
                .antMatchers(HttpMethod.GET,"/authenticated/**").authenticated()
//                .anyRequest().permitAll()
                .and()
            .cors()
                .and()
            .csrf().disable()
            .formLogin().disable();

//        httpSecurity.headers().frameOptions().disable();    // to be able to access H2 console

    }

}