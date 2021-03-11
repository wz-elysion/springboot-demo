package wz_ling1991.filter_interceptor_demo.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestComponent {


    public void test() {
        log.warn("TestComponent test");
    }
}