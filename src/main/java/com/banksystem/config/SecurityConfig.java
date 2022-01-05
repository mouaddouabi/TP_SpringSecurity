package com.banksystem.config;

import com.banksystem.models.AppUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                //.and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll() // (3)
                //.antMatchers("/admin").hasRole("ADMIN")
                //.antMatchers("/user").hasRole("USER")
                .antMatchers("/user").hasRole(AppUserRole.USER.name())
                .antMatchers("/admin").hasAuthority(AppUserRole.ADMIN.name())
                //.antMatchers(HttpMethod.POST,"/users/**").hasAuthority(AppUserRole.ADMIN.name())
                //.antMatchers(HttpMethod.PUT,"/users/**").hasAuthority(AppUserRole.ADMIN.name())
                //.antMatchers(HttpMethod.DELETE,"/users/**").hasAuthority(AppUserRole.ADMIN.name())
                //.antMatchers(HttpMethod.GET,"/users/**").hasRole(AppUserRole.USER.name())
                .anyRequest().authenticated() // (4)
                .and()
                .formLogin()// (5)
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/")// (6)
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/404");
    }
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("User1").password(passwordEncoder().encode("user"))
//                    .roles(AppUserRole.USER.name())
//                .and()
//                .withUser("Admin").password(passwordEncoder().encode("admin"))
//                    .roles(AppUserRole.ADMIN.name());
        auth.jdbcAuthentication() // 1
                .passwordEncoder(new BCryptPasswordEncoder()) // 6
                .dataSource(dataSource) // 2
                .usersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username=?") // 4
                .authoritiesByUsernameQuery("select username, authority from authorities where username=?")
        ;
    }
    /*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }*/
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

} 