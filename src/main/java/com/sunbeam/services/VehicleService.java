package com.sunbeam.services;

import java.util.List;

import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.SoldDetailsDTO;
import com.sunbeam.DTO.VehicleReqDTO;
import com.sunbeam.DTO.VehicleResDTO;
import com.sunbeam.entities.Vehicle;
import com.sunbeam.DTO.VehicleReqDTO;

public interface VehicleService {	
	ApiResponse addNewVehicle(VehicleReqDTO dto, Long userId);
	List<VehicleResDTO> getVehiclesByUsername(String userName);
	ApiResponse deleteVehiclesByUsername(String userName);
	List<SoldDetailsDTO> getVehicleDetailsByDate(String date);
	
	ApiResponse updateVehicleDetails(Long vehicleId, VehicleReqDTO dto);
	
	//Fetch all vehicles with Customer Details
	List<VehicleResDTO> getAllVehiclesWithCustomerDetails();
}
