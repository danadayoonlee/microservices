/** Project Information
  * 
  * Student Name: Dayoon Lee
  * Student Number: 301034178
  * Submission Date: 2021/11/29
  *
*/

package com.spring.jpa;

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
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/getData")
    public ModelAndView show(Model model)
    {
		System.out.println("All the product information");
		return productService.getAll(model);
    }
	
	@RequestMapping("/getJoinData")
    public ModelAndView showJoin(Model model)
    {
		System.out.println("All the product&review information");
		return productService.getAllJoin(model);
    }
	
	@RequestMapping("/")
	public ModelAndView home(Model model)
	{
		ModelAndView m = new ModelAndView("index");
		model.addAttribute("product", new Product());
		return m;
	}
	
	@PostMapping("/add")
    public @ResponseBody String add(@ModelAttribute("product") Product product, BindingResult result)
    {
		if (result.hasErrors()) {
            return "Please try again";
        }
		
		productService.add(product);
        return "A product info added";
    }
}
