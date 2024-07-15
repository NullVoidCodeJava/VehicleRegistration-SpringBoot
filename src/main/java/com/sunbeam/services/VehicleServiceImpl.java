package com.sunbeam.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.DAO.CustomerDao;
import com.sunbeam.DAO.VehicleDao;
import com.sunbeam.DTO.ApiResponse;
import com.sunbeam.DTO.SoldDetailsDTO;
import com.sunbeam.DTO.VehicleReqDTO;
import com.sunbeam.DTO.VehicleResDTO;
import com.sunbeam.DTO.VehicleReqDTO;
import com.sunbeam.custom_exceptions.ResourceNotFoundException;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.Vehicle;

@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {
	
	@Autowired
	private VehicleDao vehicleDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ModelMapper mapper;
	@Override
	public ApiResponse addNewVehicle(VehicleReqDTO dto, Long userId) {
		Customer customer = customerDao.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid CustomerID!"));
		Vehicle vehicle = mapper.map(dto, Vehicle.class);
		vehicle.setCustomer(customer);
		vehicleDao.save(vehicle);
		return new ApiResponse("New Vehicle Added!");
	}
	
	@Override
	public List<VehicleResDTO> getVehiclesByUsername(String userName) {
		List<Vehicle> persistentVehicles = vehicleDao.findByCustomerUname(userName);
		List<VehicleResDTO> vehiclesDtoList  = new ArrayList<>();
		for (Vehicle vehicle : persistentVehicles) {
			vehiclesDtoList.add(mapper.map(vehicle, VehicleResDTO.class));
		}
		return vehiclesDtoList;
	}

	@Override
	public ApiResponse deleteVehiclesByUsername(String userName) {
		List<Vehicle> persistentVehicles = vehicleDao.findByCustomerUname(userName);
		for (Vehicle vehicle : persistentVehicles) {
			vehicleDao.delete(vehicle);
		}
		return new ApiResponse("All Records Deleted for the given Customer!!");
	}

	@Override
	public List<SoldDetailsDTO> getVehicleDetailsByDate(String date) {
		LocalDate purchaseDate = LocalDate.parse(date);
		List<Vehicle> vehicleList = vehicleDao.findByPurchaseDate(purchaseDate);
		List<SoldDetailsDTO> soldDetails = new ArrayList<>();
		for (Vehicle vehicle : vehicleList) {
			 
			soldDetails.add(mapper.map(vehicle, SoldDetailsDTO.class));
		}
		
		return soldDetails;
	}

    @Override
	public ApiResponse updateVehicleDetails(Long vehicleId, VehicleReqDTO dto) {
		Vehicle vehicle = vehicleDao.findById(vehicleId).orElseThrow(() -> new ResourceNotFoundException("Vehicle not found with ID: " + vehicleId));
        mapper.map(dto, vehicle);
        vehicleDao.save(vehicle);
        return new ApiResponse("Vehicle details updated successfully!");
	}

	@Override
	public List<VehicleResDTO> getAllVehiclesWithCustomerDetails() {
		List<Vehicle> vehicleList = vehicleDao.findAll();
        List<VehicleResDTO> vehicleResList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            VehicleResDTO vehicleRes = mapper.map(vehicle, VehicleResDTO.class);
            Customer customer = customerDao.findById(vehicle.getCustomer().getUid()).orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + vehicle.getCustomer().getUid()));
//            vehicleRes.setCustomerName(customer.getUname());
            vehicleResList.add(vehicleRes);
        }
        return vehicleResList;
	}

	
}
