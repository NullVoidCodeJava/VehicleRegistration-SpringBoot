package com.sunbeam.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>{

}
