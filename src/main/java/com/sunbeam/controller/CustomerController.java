package com.sunbeam.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.entities.Customer;
import com.sunbeam.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	//adding the new customer
	@PostMapping
	public ResponseEntity<?> addNewCustomer(@RequestBody @Valid Customer customers){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customers));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/{uid}")
	public Customer getUser(@PathVariable Long uid)
	{
		return customerService.getCustomer(uid);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
	
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(customerService.deleteCustomer(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
    
	}
}
