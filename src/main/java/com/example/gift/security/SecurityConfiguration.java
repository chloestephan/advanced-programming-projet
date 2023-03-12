package com.example.gift.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public TutorUserDetailService userDetailsService() {
        return new TutorUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
               .permitAll()
                .and()
                .logout().permitAll();

//        http
//                .formLogin()
//                .loginPage("/login")
//                .failureUrl("/login-error.html")
//                .and()
//                .logout();

        return http.build();
    }


//    @Bean
//    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
//
//        http
//                .formLogin()
//                .loginPage("/login")
//                .and()
//                .logout()
//                .logoutSuccessUrl("/");
//
//
//
////        http
////                .formLogin()
////                    .loginPage("/login")
////                    .failureUrl("/login-error.html")
////                .and()
////                    .logout()
////                    .logoutSuccessUrl("/internships.html")
////                .and()
////                    .authorizeHttpRequests()
////                .requestMatchers("/login").permitAll()
//////                .requestMatchers("/", "/internships.html","/login","/css/**","/favicon.ico").permitAll()
//////                        .requestMatchers("/admin/**").hasRole("ADMIN")
//////                        .requestMatchers("/user/**").hasRole("USER")
//////                        .requestMatchers("/shared/**").hasAnyRole("USER","ADMIN")
////                        //.anyRequest().authenticated()
////                .and()
////                    .exceptionHandling()
////                    .accessDeniedPage("/403.html");
//        return http.build();
//    }


//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("jim").password("{noop}demo").roles("ADMIN").build(),
//                User.withUsername("bob").password("{noop}demo").roles("USER").build(),
//                User.withUsername("ted").password("{noop}demo").roles("USER","ADMIN").build());
//    }


}