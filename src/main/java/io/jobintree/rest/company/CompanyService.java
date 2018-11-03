package io.jobintree.rest.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	public void insert(Company company) {
		repository.insert(company);
	}
	
	public Company getCompanyById(String id) {
		return repository.findById(id).get();
	}
	
}
