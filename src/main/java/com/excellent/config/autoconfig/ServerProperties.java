package com.excellent.config.autoconfig;

import com.excellent.config.MyAutoConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MyAutoConfigurationProperties(prefix = "server")
public class ServerProperties {
    String contextPath;
    int port;
}

