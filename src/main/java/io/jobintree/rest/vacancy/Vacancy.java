package io.jobintree.rest.vacancy;

import io.jobintree.rest.company.Company;

public class Vacancy {

	private String id;
	private String name;
	
	private Company company;

	public Vacancy(String id, String name, Company company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
	
}
