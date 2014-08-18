package com.configuration;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.main.Application;

@Configuration
@PropertySource("application.properties")
public class TomcatConfig {
	
	private static final int PORT_NUMBER = 9000;
	private static final int SESSION_TIMEOUT = 10;
	
	private static final Logger logger = LoggerFactory.getLogger(TomcatConfig.class);
	
	@Value("${foo}")
	private static int port;
	
	@Autowired
	static Environment env;
	
	@Bean
	public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
	    factory.setPort(PORT_NUMBER);
	    factory.setSessionTimeout(SESSION_TIMEOUT, TimeUnit.MINUTES);
	    return factory;
	}
}
