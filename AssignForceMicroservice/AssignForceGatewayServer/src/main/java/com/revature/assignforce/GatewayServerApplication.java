package com.revature.assignforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class GatewayServerApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(GatewayServerApplication.class, args);
	}


}