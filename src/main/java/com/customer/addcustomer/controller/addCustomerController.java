package com.customer.addcustomer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.customer.addcustomer.model.addCustomerModel;
import com.customer.addcustomer.service.addCustomerService;


import java.util.List;


@Controller
public class addCustomerController {
	@Autowired
	private addCustomerService addcustomerserviceob;
	@GetMapping("/welcome")
	public ModelAndView welcome()
	{
                int x=2;
		return new ModelAndView("welcome");
	}
	//@GetMapping("/customerlist")
	@RequestMapping(value="/customerlist", method=RequestMethod.GET)
	public ModelAndView viewlist(@ModelAttribute("command") addCustomerModel custmodel, BindingResult bindingresult)
    {
	List <addCustomerModel>	list = addcustomerserviceob.customerlist();
	ModelAndView model = new ModelAndView("customerlist");
	model.addObject("customer", list);
	return model;
		
	}
	
	@RequestMapping(value="/edit.html",method=RequestMethod.GET)
	
	public ModelAndView editCustomer(@ModelAttribute("command") addCustomerModel custmodel, BindingResult bindingresult)
	{
		List<addCustomerModel> list = addcustomerserviceob.customerlist();
		 ModelAndView model = new ModelAndView("customerlist");
		 model.addObject("customer", list);
		 model.addObject("customer1", addcustomerserviceob.editgetid(custmodel.getId()));
	       
	        return model;	      		
	}
	
	@RequestMapping(value="/save.html",method=RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("command") addCustomerModel custmodel ,BindingResult bindingresult)
	{
		addcustomerserviceob.savecustomer(custmodel);
//		return new ModelAndView("redirect:/add.html");
//		ModelAndView model = new ModelAndView("redirect:/editEmployees");
		List<addCustomerModel> list = addcustomerserviceob.customerlist();
		ModelAndView model = new ModelAndView("editedcustlist");
		model.addObject("customer",list); 
		return model;	 
		
	}	
	@RequestMapping(value="/delete.html",method=RequestMethod.GET)
	public ModelAndView del(@ModelAttribute("command") addCustomerModel custmodel,BindingResult bindingresult)
	{
		//addcustomerserviceob.deletecustomer(custmodel);
		addCustomerModel customer =  addcustomerserviceob.get(custmodel.getId());
		 ModelAndView model = new ModelAndView("deletecust");
		 model.addObject("customer", customer);
		 addcustomerserviceob.deletecustomer(custmodel);
		 return model;
		
	//	List<addCustomerModel> list = addcustomerserviceob.customerlist();
	//	ModelAndView model = new ModelAndView("editedcustlist");
		//model.addObject("customer",list); 
		
		//return model;
		
		
	}
	@GetMapping("/getcustomer/{id}")
	public ModelAndView get(@PathVariable int id)
	{
		addCustomerModel customer =  addcustomerserviceob.get(id);
		 ModelAndView model = new ModelAndView("getcust");
		 model.addObject("customer", customer);
		 return model;
		
		
	}
	
	

}
