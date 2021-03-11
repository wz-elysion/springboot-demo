package wz_ling1991.filter_interceptor_demo.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import wz_ling1991.filter_interceptor_demo.component.TestComponent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@Component
public class TestInterceptor implements HandlerInterceptor {

    @Autowired
    private TestComponent testComponent;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.warn("TestInterceptor[{}] preHandle", this.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        testComponent.test();
        log.warn("TestInterceptor[{}] postHandle", this.toString());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.warn("TestInterceptor[{}] afterCompletion", this.toString());
    }
}
