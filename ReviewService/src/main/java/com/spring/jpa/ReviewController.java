/** Project Information
  * 
  * Student Name: Dayoon Lee
  * Student Number: 301034178
  * Submission Date: 2021/11/29
  *
*/

package com.spring.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@RequestMapping("/getData")
    public ModelAndView show(Model model)
    {
		System.out.println("All the review information");
		return reviewService.getAll(model);
    }
	
	@RequestMapping("/")
	public ModelAndView home(Model model)
	{
		ModelAndView m = new ModelAndView("index");
		model.addAttribute("review", new Review());
		return m;
	}
	
	@PostMapping("/add")
    public @ResponseBody String add(@ModelAttribute("review") Review review, BindingResult result)
    {
		if (result.hasErrors()) {
            return "Please try again";
        }
		
		reviewService.add(review);
        return "A review info added";
    }
}
