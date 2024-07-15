package com.sunbeam.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.CustomerDao;
import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.entities.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public ApiResponse addCustomer(Customer customer) {
		customerDao.save(customer);
		return new ApiResponse("New Customer Added!!!");
	}
	
	@Override
	public Customer getCustomer(Long id) {
		return customerDao.findById(id).get();
	}

	@Override
	public List<Customer> getAllCustomers() {
	   return customerDao.findAll();
	}

	@Override
	public ApiResponse deleteCustomer(Long id) {
		customerDao.deleteById(id);
		return new ApiResponse("Customer deleted Successfully!!!");
	}
	
}
