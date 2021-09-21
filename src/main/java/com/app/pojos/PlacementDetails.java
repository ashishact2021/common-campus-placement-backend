package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "placement_details")
public class PlacementDetails extends BaseEntity {
	
	// form 7

	@Column(length = 20)
	private String round;

	@Column(length = 5, name = "is_selected")
	@Enumerated(EnumType.STRING)
	private SelectionStatus isSelected;

	// defaut const
	public PlacementDetails() {
		System.out.println("PlacementDetails.PlacementDetails()");
	}

	// associaton
	@OneToOne
	@JoinColumn(name = "company_id")
	private Company company;

	// toString
	@Override
	public String toString() {
		return "PlacementDetails [round=" + round + ", isSelected=" + isSelected + ", company=" + company + ", getId()="
				+ getId() + "]";
	}

}