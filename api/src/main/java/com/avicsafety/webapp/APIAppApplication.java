package com.avicsafety.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class APIAppApplication extends SpringBootServletInitializer{

	    @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(APIAppApplication.class);
	    }


    public static void main(String[] args) throws Exception {
    	//API服务器
         SpringApplication.run(APIAppApplication.class, args);
    }
}