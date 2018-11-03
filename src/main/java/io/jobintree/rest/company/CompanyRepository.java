package io.jobintree.rest.company;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<Company, String>{
	
}
