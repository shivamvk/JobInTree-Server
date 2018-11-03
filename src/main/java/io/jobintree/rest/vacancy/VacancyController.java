package io.jobintree.rest.vacancy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jobintree.rest.company.Company;
import io.jobintree.rest.company.CompanyService;
import io.jobintree.rest.response.Response;

@RestController
public class VacancyController {

	@Autowired
	private VacancyService service;
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping(value="/vacancy")
	public Response addVacancy(@RequestParam String id,
			@RequestParam String name,
			@RequestParam String company_id) {
		Vacancy vacancy = new Vacancy(id, name, null);
		Company company = companyService.getCompanyById(company_id);
		vacancy.setCompany(company);
		service.insert(vacancy);
		List<Object> list = new ArrayList<>();
		list.add(vacancy);
		Response response = new Response(200, list, "Okay.");
		return response;
	}
	
	@GetMapping(value="/vacancy")
	public Response getAllVacancy() {
		List<Object> list = new ArrayList<>();
		List<Vacancy> listVacancy = service.getAllVacancy();
		for(Vacancy vacancy : listVacancy) {
			list.add(vacancy);
		}
		Response response = new Response(200, list, "Okay.");
		return response;
	}
}

