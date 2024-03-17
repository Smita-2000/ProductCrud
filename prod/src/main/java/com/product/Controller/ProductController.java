package com.product.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.DAO.ProductDAO;
import com.product.Entity.product;


@RestController
@CrossOrigin("http://localhost:4200")
public class ProductController {

	@Autowired
	ProductDAO productDao;
	
	@PostMapping("saveProduct")
	public void saveProduct(@RequestBody product prod)
	{
		System.out.println(prod);
		productDao.saveToDb(prod);		
	}
	@GetMapping("getAllProduct")
	public ResponseEntity<List<product>> getAllProduct()
	{
		System.out.println(productDao.getAllProducts());
		List<product> list=productDao.getAllProducts();
		
		return new ResponseEntity<List<product>>(list,HttpStatus.OK) ;
	}
	
	@GetMapping("getProduct/{id}")
	public ResponseEntity<product> getProduct(@PathVariable int id)
	{
		
		return new ResponseEntity<product>(productDao.getProduct(id),HttpStatus.OK) ;
	}
	@RequestMapping("deleteProduct/{id}")
	public ResponseEntity<product> deleteProduct(@PathVariable int id)
	{
		
		return new ResponseEntity<product>(productDao.deleteProduct(id),HttpStatus.OK) ;
	}
	@RequestMapping("updateProduct")
	public ResponseEntity<product> updateProduct(@RequestBody product prod)
	{
		
		return new ResponseEntity<product>(productDao.updateProduct(prod),HttpStatus.OK) ;
	}
}
