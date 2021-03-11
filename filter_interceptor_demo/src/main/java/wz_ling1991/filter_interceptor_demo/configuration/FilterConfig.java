package wz_ling1991.filter_interceptor_demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import wz_ling1991.filter_interceptor_demo.filter.TestFilter;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {

    @Autowired
    private TestFilter testFilter;

    @Bean
    public FilterRegistrationBean<Filter> registration() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(testFilter);//实例化Filter类
        filterRegistrationBean.addUrlPatterns("/*");//设置匹配模式,这里设置为所有，可以按需求设置为"/hello"等等
        filterRegistrationBean.setName("TestFilter");//设置过滤器名称
        filterRegistrationBean.setOrder(1);//设置执行顺序
        return filterRegistrationBean;
    }
}