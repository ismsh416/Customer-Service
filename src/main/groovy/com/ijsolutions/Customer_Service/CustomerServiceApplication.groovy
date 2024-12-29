package com.ijsolutions.Customer_Service

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class CustomerServiceApplication {

	static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication, args)
	}

}
