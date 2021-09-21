package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name = "companies")
public class Company extends BaseEntity {

	@Column(length = 100, unique = true)
	private String name;

	@Column(length = 50, unique = true)
	private String link;

	public Company(String name, String link) {
		this.name = name;
		this.link = link;
	}

	// association
	// company and qustion
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "company_id")
	private List<Question> questions = new ArrayList<>();

	// default const
	public Company() {
		System.out.println("Company.Company()");
	}

	// toString
	@Override
	public String toString() {
		return "Company [name=" + name + ", link=" + link + ", getId()=" + getId() + "]";
	}

}
