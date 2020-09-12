package com.revature.assignforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
/*@SpringBootApplication(scanBasePackages={
"com.revature.assignforce", "com.revature.assignforce.beans", "com.revature.assignforce.controllers",
"com.revature.assignforce.repos", "com.revature.assignforce.service"})*/
public class BatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchServiceApplication.class, args);
	}
}
