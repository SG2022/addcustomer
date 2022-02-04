package com.customer.addcustomer.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.customer.addcustomer.model.addCustomerModel;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository("addcustomerdaoob")
public class addCustomerDaoImpl implements addCustomerDao {
	@Autowired SessionFactory sessionfactoryob;
	@Autowired
	private EntityManager entityManager;
	@Override
	public List<addCustomerModel> customerlist() {
		// TODO Auto-generated method stub
		return sessionfactoryob.openSession().createCriteria(addCustomerModel.class).list();
	}

	@Override
	public addCustomerModel editgetid(Integer id) {
		// TODO Auto-generated method stub
		return sessionfactoryob.openSession().get(addCustomerModel.class, id); 
	}
     
	

	@Override
	public void savecustomer(addCustomerModel custmodel) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(custmodel);
		
		
	}

	@Override
	public void deletecustomer(addCustomerModel custmodel) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		addCustomerModel customerobj = currentSession.get(addCustomerModel.class, custmodel.getId());
		System.out.println("customer Id------->"+customerobj);

		currentSession.delete(customerobj);
		
	}
	
	@Override
	public addCustomerModel  get(int id)
	{
		Session currentSession = entityManager.unwrap(Session.class);
		addCustomerModel customerobj= currentSession.get(addCustomerModel.class, id);
		return customerobj;
	}

	

}
