package com.cdac.project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource datasource;

    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    public WebSecurityConfig(AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/bootstrap/**", "/dist/**", "/plugins/**","/api/**","/signup").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .failureUrl("/login?error")
                .loginPage("/login")
                .successHandler(authenticationSuccessHandler)
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll();
    }
    



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //Use Spring Boots User detailsMAnager
        JdbcUserDetailsManager userDetailsService = new JdbcUserDetailsManager();

        //Set our Datasource to use the one defined in application.properties
        userDetailsService.setDataSource(datasource);

        //Create BCryptPassword encoder
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        //add components
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
        auth.jdbcAuthentication().dataSource(datasource);

        // add new user "user" with password "password" - password will be encrypted
        if (!userDetailsService.userExists("anuj")) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            
            authorities.add(new SimpleGrantedAuthority("APPLICANT"));
            User userDetails = new User("anuj", encoder.encode("1234"), authorities);
            userDetailsService.createUser(userDetails);
        }
        
        if (!userDetailsService.userExists("atul")) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            
            authorities.add(new SimpleGrantedAuthority("FACULTY_ADMIN"));
            User userDetails = new User("atul", encoder.encode("1234"), authorities);
            userDetailsService.createUser(userDetails);
        }
        
        if (!userDetailsService.userExists("madhuri")) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            
            authorities.add(new SimpleGrantedAuthority("COURSE_ADMIN"));
            User userDetails = new User("madhuri", encoder.encode("1234"), authorities);
            userDetailsService.createUser(userDetails);
        }
        if (!userDetailsService.userExists("sathish")) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            
            authorities.add(new SimpleGrantedAuthority("FACULTY"));
            User userDetails = new User("sathish", encoder.encode("1234"), authorities);
            userDetailsService.createUser(userDetails);
        }
        
        
        
        
    }

}
