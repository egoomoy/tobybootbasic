package com.excellent.config.autoconfig;

import com.excellent.config.ConditionalMyOnClass;
import com.excellent.config.MyAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@MyAutoConfiguration
//@Conditional(TomcatWebServerConfig.TomcatConfition.class)
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {
    @Bean("tomcatWebServerFactory")
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }

//    static class TomcatConfition implements Condition {
//        @Override
//        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//            boolean present = ClassUtils.isPresent("org.apache.catalina.startup.Tomcat", context.getClassLoader());
//            return present;
//        }
//    }
}