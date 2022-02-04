package com.customer.addcustomer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.addcustomer.dao.addCustomerDao;
import com.customer.addcustomer.model.addCustomerModel;


@Service("addcustomerserviceob")
public class addCustomerServiceImpl implements addCustomerService {
@Autowired
private addCustomerDao addcustomerdaoob;

@Override
@Transactional
public List<addCustomerModel> customerlist() {
	// TODO Auto-generated method stub
	return addcustomerdaoob.customerlist();
}

@Override
@Transactional
public addCustomerModel editgetid(Integer id) {
	// TODO Auto-generated method stub
	return addcustomerdaoob.editgetid(id);
}

@Override
@Transactional
public void savecustomer(addCustomerModel custmodel) {
	
	addcustomerdaoob.savecustomer(custmodel);
	
}

@Override
@Transactional
public void deletecustomer(addCustomerModel custmodel) {
	// TODO Auto-generated method stub
	addcustomerdaoob.deletecustomer(custmodel);
	
}

@Override
@Transactional
public addCustomerModel get(int id) {
	// TODO Auto-generated method stub
	return addcustomerdaoob.get(id);
}




}
