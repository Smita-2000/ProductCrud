package com.product.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.Entity.product;

@Repository
public class ProductDAO {

	@Autowired
	SessionFactory factory;
	public void saveToDb(product prod)
	{
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(prod);
		tx.commit();
		
	}
	public List<product> getAllProducts()
	{
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(product.class);
		return criteria.list();
		
	}
	public product getProduct(int id)
	{
		Session session=factory.openSession();
		product prod=session.get(product.class, id);
		return prod;
	}
	public product deleteProduct(int id)
	{
		Session session=factory.openSession();
		product prod=session.get(product.class, id);
		session.delete(prod);
		session.beginTransaction().commit();
		return prod;
	}
	public product updateProduct(product prod)
	{
		
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(prod);
		tx.commit();
		return prod;
	}
	
}
