/** Project Information
  * 
  * Student Name: Dayoon Lee
  * Student Number: 301034178
  * Submission Date: 2021/11/29
  *
*/

package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	public ModelAndView getAll(Model model) {
		ModelAndView m = new ModelAndView("show");
		model.addAttribute("reviews", reviewRepository.findAll());
		return m;
	}
	
	public String add(Review review) {
		reviewRepository.save(review);
		return "A review info saved";
	}
}
