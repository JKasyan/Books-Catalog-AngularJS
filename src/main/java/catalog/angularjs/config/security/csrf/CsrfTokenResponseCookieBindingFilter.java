package catalog.angularjs.config.security.csrf;

import org.apache.log4j.Logger;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by evgen on 25.01.16.
 */
public class CsrfTokenResponseCookieBindingFilter extends OncePerRequestFilter {

    protected static final String REQUEST_ATTRIBUTE_NAME = "_csrf";
    private static final Logger logger = Logger.getLogger(CsrfTokenResponseCookieBindingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        CsrfToken token = (CsrfToken)request.getAttribute(REQUEST_ATTRIBUTE_NAME);
        logger.info("Token: " + token);
        Cookie cookie = new Cookie(CSRF.RESPONSE_COOKIE_NAME, token.getToken());
        cookie.setPath("/");
        response.addCookie(cookie);
        filterChain.doFilter(request, response);
    }
}
