package catalog.angularjs.config.security;

import catalog.angularjs.config.security.cors.CORSFilter;
import catalog.angularjs.config.security.rest.RESTAuthenticationEntryPoint;
import catalog.angularjs.config.security.rest.RESTAuthenticationSuccessHandler;
import catalog.angularjs.config.security.rest.RESTLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * Created by evgen on 25.01.16.
 */
@Configuration
public class SecurityConfiguration {

    @Bean
    public RESTAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RESTAuthenticationEntryPoint();
    }

    @Bean
    public SimpleUrlAuthenticationFailureHandler simpleUrlAuthenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler();
    }

    @Bean
    public RESTAuthenticationSuccessHandler restAuthenticationSuccessHandler() {
        return new RESTAuthenticationSuccessHandler();
    }

    @Bean
    public CORSFilter corsFilter() {
        return new CORSFilter();
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new RESTLogoutSuccessHandler();
    }
}
