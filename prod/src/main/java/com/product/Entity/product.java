package com.product.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class product {

	@Id
	int id;
	String name;
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
	@Override
	public String toString() {
		return "product [id=" + id + ", name=" + name + "]";
	}
	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
}
