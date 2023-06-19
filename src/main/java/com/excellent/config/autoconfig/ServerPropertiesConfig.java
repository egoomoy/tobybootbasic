package com.excellent.config.autoconfig;

import com.excellent.config.MyAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@MyAutoConfiguration
public class ServerPropertiesConfig {
    @Bean
    public ServerProperties serverProperties(Environment env) {
        ServerProperties serverProperties = new ServerProperties();

        serverProperties.setContexPath(env.getProperty("contextPath"));
        serverProperties.setPort(Integer.parseInt(env.getProperty("port")));
        return serverProperties;
    }

}
