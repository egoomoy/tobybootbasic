package com.excellent.config.autoconfig;

import com.excellent.config.MyAutoConfiguration;
import com.excellent.config.MyAutoConfigurationProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.env.Environment;

import java.util.Map;

import static org.springframework.core.annotation.AnnotationUtils.getAnnotationAttributes;

@MyAutoConfiguration
public class PropertyPostProcessorConfig {
    @Bean
    BeanPostProcessor propertyPostProcessor(Environment env) {
        return new BeanPostProcessor() {
            @Override
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                MyAutoConfigurationProperties annotation = AnnotationUtils.findAnnotation(bean.getClass(), MyAutoConfigurationProperties.class);
                if (annotation == null) return null;
                Map<String, Object> attrs = getAnnotationAttributes(annotation);
                String prefix = (String) attrs.get("prefix");
                return Binder.get(env).bindOrCreate(prefix, bean.getClass());
            }
        };
    }

}
