package com.baeldung.ls.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:additional.properties")
public class AppConfig {

}
