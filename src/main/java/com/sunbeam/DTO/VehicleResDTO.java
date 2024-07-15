package com.sunbeam.DTO;

import com.sunbeam.entities.Company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class VehicleResDTO {
	private String vname;
	private Company company;
	private String vnumber;
	private String vtype;
	private Double price;
	
}
