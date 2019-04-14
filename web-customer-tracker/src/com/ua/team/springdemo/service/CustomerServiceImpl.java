package com.ua.team.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ua.team.springdemo.dao.CustomerDAO;
import com.ua.team.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
}
