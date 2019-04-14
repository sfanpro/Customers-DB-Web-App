package com.ua.team.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ua.team.springdemo.dao.CustomerDAO;
import com.ua.team.springdemo.entity.Customer;

@Repository
public class CustomerServiceImpl implements CustomerService {

	// need inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
}
