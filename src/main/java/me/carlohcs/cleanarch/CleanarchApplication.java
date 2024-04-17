package me.carlohcs.cleanarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// v this is for Springboot 3.0.0
// import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
// import org.springframework.cloud.openfeign.FeignAutoConfiguration;


@EnableFeignClients
@SpringBootApplication
// v Fix: Consider defining a bean of type 'org.springframework.cloud.openfeign.FeignContext' in your configuration
// @ImportAutoConfiguration({FeignAutoConfiguration.class})
public class CleanarchApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanarchApplication.class, args);
	}

}
