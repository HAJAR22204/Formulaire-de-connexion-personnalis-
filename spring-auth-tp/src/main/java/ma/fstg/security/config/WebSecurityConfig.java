package ma.fstg.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService utilisateurs() {
        UserDetails gestionnaire = User.withUsername("gestionnaire")
                .password("{noop}admin2024")
                .roles("ADMIN")
                .build();

        UserDetails employe = User.withUsername("employe")
                .password("{noop}user2024")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(gestionnaire, employe);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/connexion", "/static/**", "/css/**").permitAll()
                .requestMatchers("/gestion/**").hasRole("ADMIN")
                .requestMatchers("/espace/**").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/connexion")
                .loginProcessingUrl("/traitement-connexion")
                .defaultSuccessUrl("/accueil", true)
                .failureUrl("/connexion?echec=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/deconnexion")
                .logoutSuccessUrl("/connexion?deconnecte=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }
}
