package com.sunbeam.services;

import java.util.List;

import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.entities.Customer;

public interface CustomerService {
	
	ApiResponse addCustomer(Customer customer);
	
	public Customer getCustomer(Long id);

	List<Customer> getAllCustomers();

    //Delete Respective Customer
	ApiResponse deleteCustomer(Long id);
	
}
