package com.jourey.angularjourney;

import java.io.Console;
import java.util.Arrays;

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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private RestAuthenticationSuccessHandler authenticationSuccessHandler; 

  @Bean
  PasswordEncoder getPasswordEncoder() {
     return new BCryptPasswordEncoder();
  }

  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();
      configuration.setAllowedOrigins(Arrays.asList("*"));
      configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
      configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token"));
      configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
  }

  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
        .userDetailsService(userDetailsService)
        .passwordEncoder(getPasswordEncoder());
  }

  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .cors()
            .and()
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
              new Http401AuthenticationEntryPoint("Basic realm=\"login\"")
            );
    }
}