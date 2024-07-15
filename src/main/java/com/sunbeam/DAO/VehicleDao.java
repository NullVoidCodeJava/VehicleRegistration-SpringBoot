package com.sunbeam.DAO;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Long>{
	
	List<Vehicle> findByCustomerUname(String userName);
	List<Vehicle> findByPurchaseDate(LocalDate purchaseDate);

}
