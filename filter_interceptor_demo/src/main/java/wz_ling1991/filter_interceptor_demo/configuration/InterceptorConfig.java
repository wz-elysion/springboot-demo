package wz_ling1991.filter_interceptor_demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import wz_ling1991.filter_interceptor_demo.interceptor.TestInterceptor;

@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {


    @Autowired
    private TestInterceptor testInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor)
                .addPathPatterns("/**");
        super.addInterceptors(registry);//最后将register往这里塞进去就可以了
    }

}