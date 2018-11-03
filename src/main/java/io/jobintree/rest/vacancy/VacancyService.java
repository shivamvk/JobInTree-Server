package io.jobintree.rest.vacancy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyService {

	@Autowired
	private VacancyRepository repository;
	
	public void insert(Vacancy vacancy) {
		repository.insert(vacancy);
	}
	
	public List<Vacancy> getAllVacancy(){
		return repository.findAll();
	}
}
