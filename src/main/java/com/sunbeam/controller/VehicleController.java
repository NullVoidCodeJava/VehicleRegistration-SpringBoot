package com.sunbeam.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.DTO.VehicleReqDTO;
import com.sunbeam.services.VehicleService;


@RestController
@RequestMapping("/vehicles")
@Validated
public class VehicleController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@PostMapping("/{userId}")
	public ResponseEntity<?> addNewVehicle(@RequestBody @Valid VehicleReqDTO dto, @PathVariable @NotNull Long userId){
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addNewVehicle(dto, userId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@GetMapping("/get/{userName}")
	public ResponseEntity<?> getVehicleDetails(@PathVariable @NotNull String userName){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehiclesByUsername(userName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{userName}")
	public ResponseEntity<?> deleteVehicleDetails(@PathVariable @NotNull String userName){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(vehicleService.deleteVehiclesByUsername(userName));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
//	@GetMapping("/{purchaseDate}")
//	public ResponseEntity<?> getVehicleDetailsByDate(@PathVariable @NotNull String purchaseDate){
//		try {
//			return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getVehicleDetailsByDate(purchaseDate));
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//		}
//	}
	
	//Update vehicle details(v_name,v_type,price)
	@PostMapping("/update/{vehicleId}")
    public ResponseEntity<?> updateVehicleDetails(@RequestBody VehicleReqDTO dto, @PathVariable @NotNull Long vehicleId){
		try {
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.updateVehicleDetails(vehicleId, dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
	}
	
	//Fetch all vehicles with Customer Details
	@GetMapping("/all")
    public ResponseEntity<?> getAllVehicleDetails(){
		try {
            return ResponseEntity.status(HttpStatus.OK).body(vehicleService.getAllVehiclesWithCustomerDetails());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
	}
}
