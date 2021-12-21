/** Project Information
  * 
  * Student Name: Dayoon Lee
  * Student Number: 301034178
  * Submission Date: 2021/11/29
  *
*/

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
 
@SpringBootApplication
public class MicroServiceApplication {
    @Bean
    @LoadBalanced
	public RestTemplate getrestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(MicroServiceApplication.class, args);
	}
}