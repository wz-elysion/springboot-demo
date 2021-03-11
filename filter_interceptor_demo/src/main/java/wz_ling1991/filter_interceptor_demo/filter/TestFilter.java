package wz_ling1991.filter_interceptor_demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wz_ling1991.filter_interceptor_demo.component.TestComponent;

import javax.servlet.*;
import java.io.IOException;

@Component
@Slf4j
public class TestFilter implements Filter {

    @Autowired
    private TestComponent testComponent;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.warn("TestFilter[{}] doFilter", this.toString());
        testComponent.test();
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.warn("TestFilter[{}] init", this.toString());
    }

    @Override
    public void destroy() {
        log.warn("TestFilter[{}] destroy", this.toString());
    }
}