package catalog.angularjs.config.security;

import catalog.angularjs.config.security.cors.CORSFilter;
import catalog.angularjs.config.security.csrf.CsrfTokenResponseCookieBindingFilter;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;

import javax.annotation.Resource;

/**
 * Created by evgen on 25.01.16.
 */
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;
    @Resource
    private AuthenticationFailureHandler authenticationFailureHandler;
    @Resource
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Resource
    private CORSFilter corsFilter;
    @Resource
    private LogoutSuccessHandler logoutSuccessHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder
                .inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/*/**").permitAll()
                .antMatchers("/login", "/controllers/**").permitAll()
                .antMatchers("/logout", "/controllers/**").permitAll();

        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
        http.formLogin().successHandler(authenticationSuccessHandler);
        http.formLogin().failureHandler(authenticationFailureHandler);

        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);

        http.addFilterBefore(corsFilter, ChannelProcessingFilter.class);

        http.csrf().requireCsrfProtectionMatcher(new AndRequestMatcher(
                new NegatedRequestMatcher(new AntPathRequestMatcher("/login*/**", HttpMethod.OPTIONS.toString())),
                new NegatedRequestMatcher(new AntPathRequestMatcher("/logout*/**", HttpMethod.OPTIONS.toString())),
                new NegatedRequestMatcher(new AntPathRequestMatcher("/login*/**", HttpMethod.OPTIONS.toString()))
        ));

        http.addFilterAfter(new CsrfTokenResponseCookieBindingFilter(), CsrfFilter.class);
    }
}
