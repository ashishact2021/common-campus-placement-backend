package com.app.dto;

import lombok.Getter;
import lombok.Setter;


// dto to send the  custom successful message to the front end. 
@Getter
@Setter
public class SuccessMessageDto {

	private String message;
	public SuccessMessageDto() {
          System.out.println("SuccessMessageDto.SuccessMessageDto()");
	}

}
