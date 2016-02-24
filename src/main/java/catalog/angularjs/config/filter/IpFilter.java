package catalog.angularjs.config.filter;

import catalog.angularjs.dao.VisitorDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by evgen on 24.02.16.
 */
@Configuration
public class IpFilter implements Filter {

    @Autowired
    VisitorDao visitorDao;
    private final static Logger logger = Logger.getLogger(IpFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
//        String ip = request.getRemoteAddr();
//        logger.debug("IP: " + ip);
//        visitorDao.save(ip);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    @Bean
    public Filter ipFilter() {
        return new IpFilter();
    }
}
