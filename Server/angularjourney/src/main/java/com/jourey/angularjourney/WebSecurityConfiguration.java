package com.jourey.angularjourney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private RestAuthenticationSuccessHandler authenticationSuccessHandler; 

  @Bean
  PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth.eraseCredentials(false)
              .userDetailsService(userDetailsService)
              .passwordEncoder(passwordEncoder());
  }
  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests()
            .antMatchers("/resources/", "/webjars/","/assets/")
            .permitAll()
            .anyRequest().authenticated()
            .and()
            // LOGIN
          .formLogin()
            .loginProcessingUrl("/login").permitAll()
            // .defaultSuccessUrl("/welcome")
            .successHandler(authenticationSuccessHandler)
            .failureHandler(new SimpleUrlAuthenticationFailureHandler())
            .usernameParameter("email")
            .passwordParameter("pass")
            .and()
          // LOGOUT
          .logout()
            .permitAll()
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler())
            // .logoutUrl("/logout")
            // .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .and()
             // CSRF
          .csrf().disable().
            authorizeRequests().antMatchers(HttpMethod.OPTIONS, "/**").permitAll().anyRequest().authenticated()
            .and().httpBasic()
            .and()
          .exceptionHandling()
            .authenticationEntryPoint(
              new Http401AuthenticationEntryPoint("Basic realm=\"MyApp\"")
            );
    }
}