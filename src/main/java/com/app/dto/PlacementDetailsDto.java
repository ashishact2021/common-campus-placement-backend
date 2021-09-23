package com.app.dto;

import com.app.pojos.Round;
import com.app.pojos.SelectionStatus;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlacementDetailsDto {
	private String  round;
	private String isSelected;
	private String CompanyName;

	// default construcotr
	public PlacementDetailsDto() {
		System.out.println("PlacementDetailsDto.PlacementDetailsDto()");
	}

}
