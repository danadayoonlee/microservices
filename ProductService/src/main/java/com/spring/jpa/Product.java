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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min=1 , max = 15, message = "Name is not valid")
	private String name;
	@NotNull
	private long price;
	@NotNull
	@Min(1)
	private int quantity;
	@NotBlank(message = "Location is mandatory")
	private String location;

	public Product() {

	}

	public Product(String name, long price, int quantity, String location) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.location = location;
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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
