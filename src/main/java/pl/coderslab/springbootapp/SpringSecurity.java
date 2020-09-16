package pl.coderslab.springbootapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
//                .usersByUsernameQuery( "select u.username, u.password, u.enabled from users u where u.username = ?");
//                .withUser("user").password(passwordEncoder().encode("user")).roles("user")
//                .and()
//                .withUser("it").password(passwordEncoder().encode("it")).roles("it")
//                .and()
//                .withUser("workshop").password(passwordEncoder().encode("workshop")).roles("workshop");


//        auth.inMemoryAuthentication()
//                .withUser("it").password("{noop}it").roles("it")
//                .and()
//                .withUser("user").password("{noop}user").roles("user")
//                .and()
//                .withUser("workshop").password("{noop}workshop").roles("workshop");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").anonymous()
                .antMatchers("/login").permitAll()
                .antMatchers("/gallery/**").hasRole("user")
                .antMatchers("/notification/it/**").hasRole("it")
                .antMatchers("/notification/workshop/**").hasRole("workshop")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/homePage")
                .and()
                .exceptionHandling().accessDeniedPage("/403");
    }
}
