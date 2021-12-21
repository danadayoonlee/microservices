/** Project Information
  * 
  * Student Name: Dayoon Lee
  * Student Number: 301034178
  * Submission Date: 2021/11/29
  *
*/

package com.spring.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min=1 , max = 15, message = "Name is not valid")
	private String name;
	@NotBlank(message = "Date is mandatory")
	private String date;
	@NotBlank(message = "Comment is mandatory")
	private String comment;
	@NotNull
	private int rate;
	@NotNull
	private int productId;

	public Review() {

	}

	public Review(String name, String date, String comment, int rate, int productId) {
		super();
		this.name = name;
		this.date = date;
		this.comment = comment;
		this.rate = rate;
		this.productId = productId;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public int getRate() {
		return rate;
	}
	
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	public int getProductId() {
		return productId;
	}
	
	public void setProductId(int productId) {
		this.productId = productId;
	}

}
