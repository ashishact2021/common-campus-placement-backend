package com.app.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FetchPlacementDetailsDto {

	private String cid;
	private String companyName;
	private String round;
	private String isSelected;
	
  // defatult const
	public FetchPlacementDetailsDto() {
		System.out.println("FetchPlacementDetailsDto.FetchPlacementDetailsDto()");
	}

}
