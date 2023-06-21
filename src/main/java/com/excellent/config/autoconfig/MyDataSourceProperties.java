package com.excellent.config.autoconfig;

import com.excellent.config.MyAutoConfigurationProperties;
import lombok.Getter;
import lombok.Setter;

@MyAutoConfigurationProperties(prefix = "data")
@Getter
@Setter
public class MyDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
