package com.markit.cds.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.markit.cds.cache.CacheLocalConfig;

@SpringBootApplication
@ComponentScan(basePackages = "com.markit")
public class WebAppInitializer {

    public static void main(String[] args) throws Exception {
	CacheLocalConfig.initializeCache();
	SpringApplication.run(WebAppInitializer.class, args);
    }
}