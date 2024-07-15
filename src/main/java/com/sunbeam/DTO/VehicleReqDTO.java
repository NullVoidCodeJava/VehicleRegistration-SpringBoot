package com.sunbeam.DTO;





import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
public class VehicleReqDTO {
	
	@NotBlank(message = "Vehicle Name Must not be Blank!!")
	private String vname;
	
	private Company company;
	@NotBlank(message = "Vehicle Number Must not be Blank!!")
	@Length(min = 6 ,message = "Vehicle Number Should be of At least 10 characters")
	private String vnumber;
	@NotBlank(message = "Vehicle Type Must not be Blank!!")
	private String vtype;
	@NotNull(message = "Purchase Date Must not be Blank!!")
	private LocalDate purchaseDate;
	@NotNull(message = "Price Must not be Blank!!")
	private Double price;
}
