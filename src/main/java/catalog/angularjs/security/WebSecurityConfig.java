package catalog.angularjs.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;

@EnableWebMvcSecurity
@EnableWebSecurity(debug = false)
@Configuration
@Order
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] ADMIN_SECURED_PAGES =
            new String[]{
                    "/views/modify_book.html",
                    "/views/modify_author.html",
                    "/views/create_author.html",
                    "/views/create_book.html"
            };

    private static final String[] SECURED_URLS =
            new String[]{"/api/authors/**",
                    "/api/books/**"};

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests()
                .antMatchers(ADMIN_SECURED_PAGES)
                .hasRole(UserDetailService.ROLE_ADMIN);

        http.authorizeRequests()
                .antMatchers(HttpMethod.DELETE, SECURED_URLS)
                .hasRole(UserDetailService.ROLE_ADMIN);

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, SECURED_URLS)
                .hasRole(UserDetailService.ROLE_ADMIN);

        http.authorizeRequests()
                .antMatchers(HttpMethod.PUT, SECURED_URLS)
                .hasRole(UserDetailService.ROLE_ADMIN);

        http.authorizeRequests()
                .antMatchers(SECURED_URLS)
                .hasRole(UserDetailService.ROLE_USER);

        SecurityConfigurer<DefaultSecurityFilterChain, HttpSecurity> securityConfigurerAdapter
                = new XAuthTokenConfigurer(userDetailsServiceBean());
        http.apply(securityConfigurerAdapter);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailService());
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
