/** Project Information
  * 
  * Student Name: Dayoon Lee
  * Student Number: 301034178
  * Submission Date: 2021/11/29
  *
*/

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
	@Autowired
	RestTemplate restTemplate;
	
	// Get list of products
	@RequestMapping("/product")
	public String getProduct() {
		String url = "http://Product-Service/getData";
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
	// Add new product
	@RequestMapping("/addProduct")
	public String productHome() {
		String url = "http://Product-Service/";
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
	@PostMapping("/saveProduct")
	public String addProduct() {
		String url = "http://Product-Service/add";
		String result = restTemplate.postForObject(url, addProduct(), String.class);
		return result;
	}
	
	// Get list of reviews
	@RequestMapping("/review")
	public String getReview() {
		String url = "http://Review-Service/getData";
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
	// Add new review
	@RequestMapping("/addReview")
	public String reviewHome() {
		String url = "http://Review-Service/";
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
	
	@PostMapping("/saveReview")
	public String addReview() {
		String url = "http://Review-Service/add";
		String result = restTemplate.postForObject(url, addReview(), String.class);
		return result;
	}
	
	// Get list of joined products and reviews
	@RequestMapping("/productReview")
	public String getProductReview() {
		String url = "http://Product-Service/getJoinData";
		String result = restTemplate.getForObject(url, String.class);
		return result;
	}
}
