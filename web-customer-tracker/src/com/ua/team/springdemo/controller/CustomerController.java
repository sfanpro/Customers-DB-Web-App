package com.ua.team.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ua.team.springdemo.dao.CustomerDAO;
import com.ua.team.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		// get customers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();

		// add customer to the model
		theModel.addAttribute("customers", theCustomers);

		return "list-customers";
	}

}
