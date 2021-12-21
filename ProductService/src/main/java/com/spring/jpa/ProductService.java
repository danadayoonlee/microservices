/** Project Information
  * 
  * Student Name: Dayoon Lee
  * Student Number: 301034178
  * Submission Date: 2021/11/29
  *
*/

package com.spring.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ModelAndView getAll(Model model) {
		ModelAndView m = new ModelAndView("show");
		model.addAttribute("products", productRepository.findAll());
        return m;
	}
	
	public ModelAndView getAllJoin(Model model) {
		ModelAndView m = new ModelAndView("showJoin");
		model.addAttribute("productsReviews");
		
		String productId = "";
		String reviewId = "";
		String productName = "";
		String reviewName = "";
		String reviewComment = "";
		
		Connection con;

        try
        {
            //loading the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            //establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopdb", "root", "da970118");
            //create statement object
            String sql = "select product.id as product_id, review.id as review_id, product.name as product_name, review.name as review_name, review.comment as review_comment from review inner join product on product.id=review.product_id";
            System.out.println(sql);
            //execute the query
            Statement stat = con.createStatement();
            stat.executeQuery(sql);
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next())
            {
            	productId = rs.getString("product_id");
            	reviewId = rs.getString("review_id");
            	productName = rs.getString("product_name");
            	reviewName = rs.getString("review_name");
            	reviewComment = rs.getString("review_comment");
            }
            
            stat.close();
            con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        m.addObject("product_id", productId);
        m.addObject("review_id", reviewId);
		m.addObject("product_name", productName);
		m.addObject("review_name", reviewName);
		m.addObject("review_comment", reviewComment);
		
        return m;
	}
	
	public String add(Product product) {
		productRepository.save(product);
		return "A product info saved";
	}
}
