package com.customer.addcustomer.service;

import java.util.List;

import com.customer.addcustomer.model.addCustomerModel;

public interface addCustomerService {

	public List<addCustomerModel> customerlist();

	public addCustomerModel editgetid(Integer id);

	public void savecustomer(addCustomerModel custmodel);

	public void deletecustomer(addCustomerModel custmodel);
	public addCustomerModel get(int id);



}
